    package com.example.examprojectapp.fragments

    import android.content.Context
    import android.content.SharedPreferences
    import android.os.Bundle
    import android.os.CountDownTimer
    import android.util.Log
    import androidx.fragment.app.Fragment
    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import androidx.fragment.app.viewModels
    import androidx.lifecycle.lifecycleScope
    import com.example.domain.model.MedalType
    import com.example.domain.model.QuestionsModel
    import com.example.examprojectapp.R
    import com.example.examprojectapp.databinding.FragmentQuestionBinding
    import com.example.examprojectapp.viewmodel.TestQuizViewModel
    import com.example.quizprojectapp.adapter.QuestionsAdapter
    import dagger.hilt.android.AndroidEntryPoint

    @AndroidEntryPoint
    class QuestionFragment : Fragment() {

        private lateinit var binding: FragmentQuestionBinding
        private val viewModel by viewModels<TestQuizViewModel>()
        private val adapter = QuestionsAdapter()
        private var currentQuestionIndex = 0
        private var isCurrentQuestionAnswered = false
        private var correctAnswersCount = 0
        private var id: String? = null
        private var idExam: String? = null
        private var name: String? = null
        private var nameExam :String? = null
        private var questions: List<QuestionsModel>? = null
        private val selectedAnswers = mutableMapOf<Int, Int>()
        private lateinit var sharedPreferences: SharedPreferences
        private var timer: CountDownTimer? = null
        private var remainingTimeInSeconds = 600

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            binding = FragmentQuestionBinding.inflate(inflater, container, false)
            return binding.root
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            id = arguments?.getString("id")
            idExam = arguments?.getString("idExam")
            name = arguments?.getString("name")
            name = arguments?.getString("name")

            // Получите SharedPreferences
            sharedPreferences = requireContext().getSharedPreferences("test_results", Context.MODE_PRIVATE)

            if (idExam != null) {
                viewLifecycleOwner.lifecycleScope.launchWhenStarted {
                    viewModel.testQuiz.collect {
                        questions = it.questions.filter { it.id == idExam }
                        adapter.submitList(listOf(questions?.get(currentQuestionIndex)))
                    }
                }
                viewModel.loadQuestions()
            }

            if (id != null) {
                viewLifecycleOwner.lifecycleScope.launchWhenStarted {
                    viewModel.testQuiz.collect {
                        questions = it.questions.filter { it.id == id }
                        adapter.submitList(listOf(questions?.get(currentQuestionIndex)))
                        startTimer()
                        remainingTimeInSeconds = 59 // Обновляем время здесь
                        updateQuestionCountText()

                    }
                }
                viewModel.loadQuestions()
            }

            initAdapter()
        }

        private fun initAdapter() {
            binding.rv.adapter = adapter

            adapter.setOnAnswerClickListener(object : QuestionsAdapter.OnAnswerClickListener {
                override fun onAnswerClick(selectedIndex: Int) {
                    isCurrentQuestionAnswered = true

                    val currentQuestion = questions?.get(currentQuestionIndex)
                    if (currentQuestion != null && currentQuestion.currentAnswer.toInt() == selectedIndex) {
                        correctAnswersCount++
                    }
                }
            })


            binding.btnNext.setOnClickListener {
                if (currentQuestionIndex < questions?.size ?: 0 && isCurrentQuestionAnswered) {
                    currentQuestionIndex++
                    isCurrentQuestionAnswered = false
                    adapter.clearAnsweredQuestions()
                    startTimer()
                    remainingTimeInSeconds = 59 // Обновляем время здесь
                    updateQuestionCountText()
                    if (currentQuestionIndex < questions?.size ?: 0) {
                        adapter.submitList(listOf(questions?.get(currentQuestionIndex)))
                    }

                    if (currentQuestionIndex == questions?.size ?: 0) {
                        startTimer()
                        remainingTimeInSeconds = 59 // Обновляем время здесь
                        Log.d("QuestionFragment", "Quiz completed. Correct answers: $correctAnswersCount")
                        saveTestResultToSharedPreferences()

                        val fragment = QuestionListFragment()
                        val args = Bundle()
                        args.putInt("correctAnswersCount", correctAnswersCount)
                        args.putInt("totalQuestions", questions?.size ?: 0)
                        fragment.arguments = args

                        parentFragmentManager.beginTransaction()
                            .replace(R.id.fr_container, fragment)
                            .addToBackStack(null)
                            .commit()
                    }
                }
            }
            binding.btnPrev.setOnClickListener {
                if (currentQuestionIndex > 0) {
                    currentQuestionIndex--
                    updateQuestionCountText()
                    isCurrentQuestionAnswered = selectedAnswers.containsKey(currentQuestionIndex)
                    adapter.submitList(listOf(questions?.get(currentQuestionIndex)))
                }
            }
        }

        private fun saveTestResultToSharedPreferences() {

            val editor = sharedPreferences.edit()
            val testKey = id ?: name?: ""
            val testKeyExam = idExam ?: nameExam?: ""

            editor.putString("test_idExam_$testKeyExam", testKeyExam)
            editor.putString("test_name_$testKeyExam", nameExam?: "")
            editor.putString("test_id_$testKey", testKey)
            editor.putString("test_name_$testKey", name ?: "")
            editor.putInt("correct_answers_count_$testKey", correctAnswersCount)
            editor.apply()
        }
        private fun startTimer() {
            timer = object : CountDownTimer((remainingTimeInSeconds * 1000).toLong(), 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    remainingTimeInSeconds = (millisUntilFinished / 1000).toInt()
                    updateTimerText()
                    Log.d("Timer", "Remaining Time: $remainingTimeInSeconds seconds")
                }

                override fun onFinish() {
                    // Время истекло, выполните действия, если необходимо
                    Log.d("Timer", "Timer Finished")
                }
            }.start()
        }

        private fun updateTimerText() {
            val minutes = remainingTimeInSeconds / 60
            val seconds = remainingTimeInSeconds % 60
            val formattedTime = String.format("%02d:%02d", minutes, seconds)
            binding.tvSecund.text = formattedTime
        }
        private fun updateQuestionCountText() {
            val currentQuestionNumber = currentQuestionIndex + 1
            val totalQuestions = questions?.size ?: 0
            val questionCountText = "$currentQuestionNumber/$totalQuestions"
            binding.tvCount.text = questionCountText
        }

    }
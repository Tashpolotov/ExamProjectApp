package com.example.examprojectapp.utils

import android.content.Context
import com.example.domain.model.HomeModel1
import com.example.domain.model.HomeModel2
import com.example.domain.model.QuestionsModel
import com.example.domain.repository.TestQuizRepository
import com.example.examprojectapp.R

class TestQuizRepositoryMock(private val context: Context):TestQuizRepository{



    override fun getHome1(): List<HomeModel1> {
        return listOf(HomeModel1(
            "1", R.drawable.img_item_home1, context.getString(R.string.math_final_exam), context.getString(
                            R.string.minutes)),
            HomeModel1(
                "2", R.drawable.img_item_home2, context.getString(R.string.biology_daily_quiz), context.getString(
                    R.string.minutes)),
            HomeModel1(
                "3", R.drawable.img_item_home3, context.getString(R.string.chemistry_final_test), context.getString(
                    R.string.minutes)),



            )
    }

    override fun getHome2(): List<HomeModel2> {
      return listOf(
          HomeModel2(
              "4", R.drawable.img_item2_4, context.getString(R.string.physics_daily_quiz), R.drawable.ic_baseline_check_24, ),
          HomeModel2(
              "5", R.drawable.img_item2_5, context.getString(R.string.math_daily_quiz), R.drawable.ic_baseline_check_24, ),
          HomeModel2(
              "6", R.drawable.img_item2_2, context.getString(R.string.literature_final_exam), R.drawable.ic_baseline_check_24, ),
      )
    }

    override fun getExam(): List<HomeModel2> {
        return listOf(
            HomeModel2(
                "1", R.drawable.img_item2_1, context.getString(R.string.math_final_exam), R.drawable.img_play, ),
            HomeModel2(
                "2", R.drawable.img_item2_2, context.getString(R.string.biology_daily_quiz), R.drawable.img_play, ),
            HomeModel2(
                "3", R.drawable.img_item2_3, context.getString(R.string.chemistry_final_test), R.drawable.img_play, ),
            HomeModel2(
                "4", R.drawable.img_item2_4, context.getString(R.string.math_daily_quiz), R.drawable.img_play, ),
            HomeModel2(
                "5", R.drawable.img_item2_5, context.getString(R.string.physics_daily_quiz), R.drawable.img_play, ),
            HomeModel2(
                "6", R.drawable.img_item2_2, context.getString(R.string.literature_final_exam), R.drawable.img_play, ),
        )
    }

    override fun getQuestions(): List<QuestionsModel> {
        return listOf(QuestionsModel("1", context.getString(R.string.math_final_exam), context.getString(
                    R.string.qestions1),
            listOf("8", "10", "12", "14"), "1"),
            QuestionsModel("1", context.getString(R.string.math_final_exam), context.getString(R.string.questions2),
                listOf("2", "5", "6", "7"), "3"),
            QuestionsModel("1", context.getString(R.string.math_final_exam), context.getString(R.string.questions3),
                listOf("10", "15", "20", "25"), "3"),
            QuestionsModel("1", context.getString(R.string.math_final_exam), context.getString(R.string.questions4),
                listOf("3.14", "3.141", "3.142", "3.143"), "0"),
            QuestionsModel("1", context.getString(R.string.math_final_exam), context.getString(R.string.questions5),
                listOf("2", "4", "8", "16"), "1"),
            QuestionsModel("1", context.getString(R.string.math_final_exam), context.getString(R.string.questions6),
                listOf("3", "4", "5", "6"), "3"),
            QuestionsModel("1", context.getString(R.string.math_final_exam), context.getString(R.string.questions7),
                listOf("2", "4", "6", "8"), "1"),
            QuestionsModel("1", context.getString(R.string.math_final_exam), context.getString(R.string.questions8),
                listOf("12", "18", "24", "30"), "2"),
            QuestionsModel("1", context.getString(R.string.math_final_exam), context.getString(R.string.questions9),
                listOf("8", "16", "24", "32"), "0"),
            QuestionsModel("1", context.getString(R.string.math_final_exam), context.getString(R.string.questions10),
                listOf("4x + 13", "5x - 7", "6x + 7", "7x - 6"), "0"),



            QuestionsModel("2", context.getString(R.string.biology_daily_quiz), context.getString(R.string.biologiQuestions1),
                listOf(context.getString(R.string.biologianswer1), "Respiration", "Digestion", "Fermentation"), "0"),
            QuestionsModel("2", context.getString(R.string.biology_daily_quiz), context.getString(R.string.biologiQuestions2),
                listOf("Nucleus", "Cytoplasm", "Mitochondria", "Endoplasmic Reticulum"), "2"),
            QuestionsModel("2", context.getString(R.string.biology_daily_quiz), context.getString(R.string.biologiQuestions3),
                listOf("Oxygen", "Carbon Dioxide", "Nitrogen", "Hydrogen"), "1"),
            QuestionsModel("2", context.getString(R.string.biology_daily_quiz), context.getString(R.string.biologiQuestions4),
                listOf("Brain", "Heart", "Skin", "Liver"), "2"),
            QuestionsModel("2", context.getString(R.string.biology_daily_quiz), context.getString(R.string.biologiQuestions5),
                listOf("A", "B", "AB", "O"), "3"),
            QuestionsModel("2", context.getString(R.string.biology_daily_quiz), context.getString(R.string.biologiQuestions6),
                listOf("O2", "H2O", "CO2", "N2"), "1"),
            QuestionsModel("2", context.getString(R.string.biology_daily_quiz), context.getString(R.string.biologiQuestions7),
                listOf("Carbon Dioxide", "Oxygen", "Nitrogen", "Helium"), "1"),
            QuestionsModel("2", context.getString(R.string.biology_daily_quiz), context.getString(R.string.biologiQuestions8),
                listOf("Transporting Oxygen", "Digesting Food", "Filtering Waste", "Producing Antibodies"), "0"),
            QuestionsModel("2", context.getString(R.string.biology_daily_quiz), context.getString(R.string.biologiQuestions9),
                listOf("Leaves", "Stem", "Roots", "Flowers"), "2"),
            QuestionsModel("2", context.getString(R.string.biology_daily_quiz), context.getString(R.string.biologiQuestions10),
                listOf("Protein", "DNA", "RNA", "Enzyme"), "1"),



            QuestionsModel("3", context.getString(R.string.chemistry_final_test), context.getString(
                            R.string.chemistryQuestions1),
                listOf("O2", "O3", "O4", "O"), "3"),
            QuestionsModel("3", context.getString(R.string.chemistry_final_test), context.getString(
                            R.string.chemistryQuestions2),
                listOf("Molecule", "Atom", "Compound", "Ion"), "1"),
            QuestionsModel("3", context.getString(R.string.chemistry_final_test), context.getString(
                            R.string.chemistryQuestions3),
                listOf("Oxygen", "Hydrogen", "Sulfur Dioxide", "Methane"), "1"),
            QuestionsModel("3", context.getString(R.string.chemistry_final_test), context.getString(
                            R.string.chemistryQuestions4),
                listOf("H2O2", "CO2", "H2O", "CH4"), "2"),
            QuestionsModel("3", context.getString(R.string.chemistry_final_test), context.getString(
                            R.string.chemistryQuestions5),
                listOf("Helium", "Neon", "Argon", "Krypton"), "0"),
            QuestionsModel("3", context.getString(R.string.chemistry_final_test), context.getString(
                            R.string.chemistryQuestions6),
                listOf("0", "7", "14", "10"), "1"),
            QuestionsModel("3", context.getString(R.string.chemistry_final_test), context.getString(
                            R.string.chemistryQuestions7),
                listOf("Carbon Dioxide", "Oxygen", "Hydrogen", "Nitrogen"), "0"),
            QuestionsModel("3", context.getString(R.string.chemistry_final_test), context.getString(
                            R.string.chemistryQuestions8),
                listOf("Au", "Ag", "Fe", "Cu"), "0"),
            QuestionsModel("3", context.getString(R.string.chemistry_final_test), context.getString(
                            R.string.chemistryQuestions9),
                listOf("Oxygen", "Silicon", "Aluminum", "Iron"), "0"),
            QuestionsModel("3", context.getString(R.string.chemistry_final_test), context.getString(
                            R.string.chemistryQuestions10),
                listOf("Evaporation", "Sublimation", "Condensation", "Boiling"), "1"),

            QuestionsModel("4", "math_daily_quiz",
                "What is 3 + 7?", listOf("7", "8", "9", "10"), "3"),
            QuestionsModel("4", "math_daily_quiz",
                "Solve for x: 2x - 4 = 6.", listOf("2", "3", "4", "5"), "3"),
            QuestionsModel("4", "math_daily_quiz",
                "What is the area of a square with side length 5?", listOf("20", "25", "30", "35"), "1"),
            QuestionsModel("4", "math_daily_quiz",
                "Find the value of π (pi) to two decimal places.", listOf("3.14", "3.141", "3.1416", "3.14159"), "3"),
            QuestionsModel("4", "math_daily_quiz",
                "What is the square root of 16?", listOf("2", "4", "6", "8"), "1"),
            QuestionsModel("4", "math_daily_quiz",
                "Solve for y: 2y - 3 = 9.", listOf("6", "7", "8", "9"), "0"),
            QuestionsModel("4", "math_daily_quiz",
                "What is 8 divided by 2?", listOf("2", "3", "4", "5"), "2"),
            QuestionsModel("4", "math_daily_quiz",
                "Find the area of a rectangle with length 6 and width 4.", listOf("18", "20", "24", "30"), "2"),
            QuestionsModel("4", "math_daily_quiz",
                "What is 10% of 80?", listOf("6", "8", "10", "12"), "1"),
            QuestionsModel("4", "math_daily_quiz",
                "Simplify the expression: 2(3x + 4) - 5(2x - 1).", listOf("5x + 6", "6x - 5", "6x + 5", "5x - 6"), "2"),


            QuestionsModel("5", "physics_daily_quiz",
                "What is the force that opposes the motion of objects through air or any fluid called?", listOf("Friction", "Gravity", "Inertia", "Tension"), "0"),
            QuestionsModel("5", "physics_daily_quiz",
                "What is the SI unit of electric current?", listOf("Volts", "Watts", "Amps", "Ohms"), "2"),
            QuestionsModel("5", "physics_daily_quiz",
                "What is the acceleration due to gravity on the surface of the Earth?", listOf("10 m/s²", "9.8 m/s²", "11.3 m/s²", "12.5 m/s²"), "1"),
            QuestionsModel("5", "physics_daily_quiz",
                "Which type of energy is stored in an object due to its position above the Earth's surface?", listOf("Kinetic energy", "Potential energy", "Thermal energy", "Electric energy"), "1"),
            QuestionsModel("5", "physics_daily_quiz",
                "What is the law that states that an object at rest tends to stay at rest and an object in motion tends to stay in motion with the same speed and in the same direction unless acted upon by an unbalanced force?", listOf("Newton's Second Law", "Law of Gravitation", "Law of Inertia", "Newton's Third Law"), "2"),
            QuestionsModel("5", "physics_daily_quiz",
                "What is the bending of light when it passes from one medium to another of different optical density?", listOf("Reflection", "Refraction", "Diffraction", "Dispersion"), "1"),
            QuestionsModel("5", "physics_daily_quiz",
                "What is the unit of measurement for frequency?", listOf("Watt", "Hertz", "Volt", "Joule"), "1"),
            QuestionsModel("5", "physics_daily_quiz",
                "What is the process of a substance changing directly from a solid to a gas without passing through the liquid phase?", listOf("Sublimation", "Vaporization", "Condensation", "Melting"), "0"),
            QuestionsModel("5", "physics_daily_quiz",
                "What is the phenomenon where a vibrating object produces sound waves through the air?", listOf("Echo", "Refraction", "Resonance", "Eclipse"), "2"),
            QuestionsModel("5", "physics_daily_quiz",
                "What is the fundamental SI unit of temperature?", listOf("Fahrenheit", "Celsius", "Kelvin", "Rankine"), "2"),



            QuestionsModel("6", "literature_final_exam",
                "Who is the author of the novel '1984'?", listOf("George Orwell", "Aldous Huxley", "F. Scott Fitzgerald", "Ray Bradbury"), "0"),
            QuestionsModel("6", "literature_final_exam",
                "In which Shakespeare play would you find the character Othello?", listOf("Macbeth", "Romeo and Juliet", "Hamlet", "Othello"), "3"),
            QuestionsModel("6", "literature_final_exam",
                "Who wrote the poem 'The Waste Land'?", listOf("Robert Frost", "Langston Hughes", "T.S. Eliot", "Walt Whitman"), "2"),
            QuestionsModel("6", "literature_final_exam",
                "Which classic novel is subtitled 'The Modern Prometheus'?", listOf("Frankenstein", "Dracula", "Pride and Prejudice", "Moby-Dick"), "0"),
            QuestionsModel("6", "literature_final_exam",
                "Who is the author of 'To Kill a Mockingbird'?", listOf("Harper Lee", "Mark Twain", "John Steinbeck", "F. Scott Fitzgerald"), "0"),
            QuestionsModel("6", "literature_final_exam",
                "Which character in 'The Lord of the Rings' is also known as Gollum?", listOf("Sauron", "Gandalf", "Frodo Baggins", "Gollum"), "3"),
            QuestionsModel("6", "literature_final_exam",
                "What is the name of the ship in Herman Melville's 'Moby-Dick'?", listOf("The Pequod", "The Nautilus", "The Hispaniola", "The H.M.S. Bounty"), "0"),
            QuestionsModel("6", "literature_final_exam",
                "Who wrote 'The Great Gatsby'?", listOf("F. Scott Fitzgerald", "Ernest Hemingway", "John Steinbeck", "Harper Lee"), "0"),
            QuestionsModel("6", "literature_final_exam",
                "In Jane Austen's 'Pride and Prejudice', who is the female protagonist?", listOf("Elizabeth Bennet", "Jane Bennet", "Catherine de Bourgh", "Lydia Bennet"), "0"),
            QuestionsModel("6", "literature_final_exam",
                "Which Russian author wrote 'Crime and Punishment'?", listOf("Leo Tolstoy", "Anton Chekhov", "Fyodor Dostoevsky", "Ivan Turgenev"), "2")

            )
    }

    override fun searchHome1(query: String): List<HomeModel1> {
        val search = getHome1().filter {
            it.title.contains(query, ignoreCase = true)
        }
        return search
    }
}
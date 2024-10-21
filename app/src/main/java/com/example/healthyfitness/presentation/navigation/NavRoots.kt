package com.example.healthyfitness.presentation.navigation

sealed class NavRoutes(val route: String) {
    object Welcome : NavRoutes("welcome")
    object FoodList : NavRoutes("food_list")
    object FoodDetail : NavRoutes("food_detail/{itemId}") {
        fun createRoute(itemId: Int) = "food_detail/$itemId"
    }
    object ExerciseSelection : NavRoutes("exercise_selection")
    object ShouldersExerciseList : NavRoutes("shoulders_exercise_list")
    object BackExerciseList : NavRoutes("back_exercise_list")
    object CardioExerciseList : NavRoutes("cardio_exercise_list")
    object NeckExerciseList : NavRoutes("neck_exercise_list")
    object NotificationList : NavRoutes("notification_list")
    object HomeScreen1 : NavRoutes("home_screen_1")
    object SignUp : NavRoutes("signup")
    object SignIn : NavRoutes("signin")
    object ShouldersExerciseDetails : NavRoutes("shoulders_exercise_details/{exerciseId}") {
        fun createRoute(exerciseId: String) = "shoulders_exercise_details/$exerciseId"
    }

    object BackExerciseDetails : NavRoutes("back_exercise_details/{exerciseId}") {
        fun createRoute(exerciseId: String) = "back_exercise_details/$exerciseId"
    }

    object CardioExerciseDetails : NavRoutes("cardio_exercise_details/{exerciseId}") {
        fun createRoute(exerciseId: String) = "cardio_exercise_details/$exerciseId"
    }

    object NeckExerciseDetails : NavRoutes("neck_exercise_details/{exerciseId}") {
        fun createRoute(exerciseId: String) = "neck_exercise_details/$exerciseId"
    }
}

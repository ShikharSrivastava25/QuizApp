package com.example.quizapp.presentation.home.component

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalGraphicsContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.quizapp.R
import com.example.quizapp.presentation.common.AppDropDownMenu
import com.example.quizapp.presentation.common.ButtonBox
import com.example.quizapp.presentation.home.EventHomeScreen
import com.example.quizapp.presentation.home.StateHomeScreen
import com.example.quizapp.presentation.nav_graph.Routes
import com.example.quizapp.presentation.util.Constants
import com.example.quizapp.presentation.util.Dimens.MediumPadding
import com.example.quizapp.presentation.util.Dimens.MediumSpacerHeight
import com.example.quizapp.presentation.util.Dimens.SmallSpacerHeight

//@Preview
//@Composable
//fun PrevHome() {
//    HomeScreen(state = StateHomeScreen(),
//        event = {}
//        )
//}

@Composable
fun HomeScreen(
    state : StateHomeScreen,
    event : (EventHomeScreen) -> Unit,
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(MediumPadding)
    ) {
        // Header
        HomeHeader()

        Spacer(modifier = Modifier.height(MediumSpacerHeight))

        // Number of Questions Dropdown
        AppDropDownMenu(
            menuName = "Number of Questions:",
            menuList = Constants.numbersAsString,
            text = state.numberOfQuiz.toString(),
            onDropDownClick = {event(EventHomeScreen.SetNumberOfQuizzes(it.toInt()))}
        )

        Spacer(modifier = Modifier.height(SmallSpacerHeight))

        // Category Dropdown
        AppDropDownMenu(
            menuName = "Select Category:",
            menuList = Constants.categories,
            text = state.category,
            onDropDownClick = {event(EventHomeScreen.SetQuizCategory(it))}
        )

        Spacer(modifier = Modifier.height(SmallSpacerHeight))

        // Difficulty Dropdown
        AppDropDownMenu(
            menuName = "Select Difficulty:",
            menuList = Constants.difficulty,
            text = state.difficulty,
            onDropDownClick = {event(EventHomeScreen.SetQuizDifficulty(it))}
        )

        Spacer(modifier = Modifier.height(SmallSpacerHeight))

        // Type Dropdown
        AppDropDownMenu(
            menuName = "Select Type:",
            menuList = Constants.type,
            text = state.type,
            onDropDownClick = {event(EventHomeScreen.SetQuizType(it))}
        )

        Spacer(modifier = Modifier.height(MediumSpacerHeight))

        // Button
        ButtonBox(
            text = "Generate Quiz",
            textColor = colorResource(id = R.color.black) ,
            padding = MediumPadding
        ) {
            navController.navigate(
                route = Routes.QuizScreen.passQuizParams(state.numberOfQuiz, state.category, state.difficulty, state.type)
            )
//            Log.d("quiz detail", "${state.numberOfQuiz}   ${state.category}   ${state.difficulty}   ${state.type}")
        }
    }
}

package com.example.quizapp.presentation.score

import android.icu.text.DecimalFormat
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import com.example.quizapp.R
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.airbnb.lottie.LottieComposition
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.quizapp.presentation.nav_graph.Routes
import com.example.quizapp.presentation.util.Dimens


@Composable
fun ScoreScreen(
    numOfQuestions: Int,
    numOfCorrectAns: Int,
    navController: NavController
) {

    BackHandler {
        goToHome(navController)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = Dimens.MediumPadding),
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            IconButton(
                onClick = {
                    goToHome(navController = navController)
                }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_close_24),
                    contentDescription = "close",
                    tint = colorResource(id = R.color.blue_grey)
                )
            }
        }

        Spacer(modifier = Modifier.height(Dimens.SmallSpacerHeight))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp)
                .clip(RoundedCornerShape(Dimens.MediumCornerRadius))
                .background(colorResource(id = R.color.blue_grey)),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier.padding(
                    horizontal = Dimens.MediumPadding,
                    vertical = Dimens.MediumPadding
                ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val composition: LottieComposition? by rememberLottieComposition(
                    LottieCompositionSpec.RawRes(R.raw.congra)
                )

                val annotatedString: AnnotatedString = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Color.Black)) {
                        append("You attempted ")
                    }
                    withStyle(style = SpanStyle(color = Color.Blue)) {
                        append("$numOfQuestions questions")
                    }
                    withStyle(style = SpanStyle(color = Color.Black)) {
                        append(" and from that ")
                    }
                    withStyle(style = SpanStyle(color = colorResource(id = R.color.green))) {
                        append("$numOfCorrectAns answers")
                    }
                    withStyle(style = SpanStyle(color = Color.Black)) {
                        append(" are correct")
                    }
                }

                val scorePercentage: Double = calculatePercentage(numOfCorrectAns, numOfQuestions)

                LottieAnimation(
                    modifier = Modifier.size(Dimens.LargeLottieAnimSize),
                    composition = composition,
                    iterations = LottieConstants.IterateForever
                )

                Spacer(modifier = Modifier.height(Dimens.SmallSpacerHeight))

                Text(
                    text = "Congrats!",
                    color = Color.Black,
                    style = MaterialTheme.typography.titleMedium,
                    fontSize = Dimens.MediumTextSize,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(Dimens.MediumSpacerHeight))

                Text(
                    text = "$scorePercentage% Score",
                    color = colorResource(id = R.color.green),
                    style = MaterialTheme.typography.titleMedium,
                    fontSize = Dimens.LargeTextSize,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(Dimens.MediumSpacerHeight))

                Text(
                    text = "Quiz completed successfully.",
                    color = Color.Black,
                    style = MaterialTheme.typography.titleMedium,
                    fontSize = Dimens.SmallTextSize,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(Dimens.MediumSpacerHeight))

                Text(
                    text = annotatedString,
                    color = Color.Black,
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(Dimens.LargeSpacerHeight))
            }
        }
    }
}

fun goToHome(navController: NavController) {
    navController.navigate(Routes.HomeScreen.route) {
        popUpTo(Routes.HomeScreen.route) {
            inclusive = true
        }
    }
}

fun calculatePercentage(k: Int , n : Int): Double {
    require(k >= 0 && n > 0) {
        "Invalid input: k must be non-negative and n must be positive"
    }

    val percentage = (k.toDouble() / n.toDouble()) * 100
    return DecimalFormat("#.##").format(percentage).toDouble()
}



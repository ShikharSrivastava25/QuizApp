package com.example.quizapp.presentation.common

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.quizapp.R
import com.example.quizapp.presentation.util.Dimens

@Composable
fun ShimmerEffectQuizInterface() {
    Column {
        // First Row (Question placeholder)
        Row(
            modifier = Modifier.padding(Dimens.SmallPadding),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .width(20.dp)
                    .height(40.dp)
                    .clip(MaterialTheme.shapes.medium)
                    .weight(1f)
                    .shimmerEffect()
            )
            Spacer(modifier = Modifier.width(5.dp))
            Box(
                modifier = Modifier
                    .width(20.dp)
                    .height(40.dp)
                    .clip(MaterialTheme.shapes.medium)
                    .weight(9f)
                    .shimmerEffect()
            )
        }

        Spacer(modifier = Modifier.height(Dimens.LargeSpacerHeight))

        // Column of options
        Column(modifier = Modifier.padding(horizontal = 15.dp)) {
            repeat(4) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(Dimens.MediumBoxHeight)
                        .clip(RoundedCornerShape(Dimens.LargeCornerRadius))
                        .shimmerEffect()
                )
                Spacer(modifier = Modifier.height(Dimens.SmallSpacerHeight))
            }
        }

        Spacer(modifier = Modifier.height(Dimens.ExtraLargeSpacerHeight))

        // Row of bottom buttons
        Row {
            Box(
                modifier = Modifier
                    .weight(0.5f)
                    .fillMaxWidth()
                    .height(Dimens.MediumBoxHeight)
                    .clip(RoundedCornerShape(Dimens.LargeCornerRadius))
                    .shimmerEffect()
            )
            Spacer(modifier = Modifier.width(Dimens.SmallSpacerWidth))
            Box(
                modifier = Modifier
                    .weight(0.5f)
                    .fillMaxWidth()
                    .height(Dimens.MediumBoxHeight)
                    .clip(RoundedCornerShape(Dimens.LargeCornerRadius))
                    .shimmerEffect()
            )
        }
    }
}

// ✅ Modifier extension for shimmer effect
fun Modifier.shimmerEffect(): Modifier = composed {

    val transition = rememberInfiniteTransition(label = " ")
    val alpha by transition.animateFloat(
        initialValue = 0.2f,
        targetValue = 0.9f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000),
            repeatMode = RepeatMode.Reverse
        ),
        label = "alphaAnim"
    )

    this.background(
        color = colorResource(id = R.color.blue_grey).copy(alpha = alpha)
    )
}

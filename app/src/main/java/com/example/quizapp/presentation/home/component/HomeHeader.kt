package com.example.quizapp.presentation.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.quizapp.R
import com.example.quizapp.presentation.util.Dimens



@Preview(showBackground = true)
@Composable
fun HomeHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(Dimens.HomeTopBoxHeight)
            .background(
                color = colorResource(id = R.color.dark_slate_blue),
                shape = RoundedCornerShape(
                    bottomStart = Dimens.LargeCornerRadius,
                    bottomEnd = Dimens.LargeCornerRadius
                )
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = Dimens.LargePadding),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_menu_open_24),
                contentDescription = "",
                modifier = Modifier
                    .weight(1f)
                    .size(Dimens.MediumIconSize),
                tint = colorResource(id = R.color.blue_grey)
            )

            Text(
                text = "Quiz App",
                color = colorResource(id = R.color.blue_grey),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.weight(3.5f),
                textAlign = TextAlign.Center,
                fontSize = Dimens.LargeTextSize
            )

            Icon(
                painter = painterResource(id = R.drawable.baseline_account_box_24),
                contentDescription = "",
                modifier = Modifier
                    .weight(1f)
                    .size(Dimens.MediumIconSize),
                tint = colorResource(id = R.color.blue_grey)
            )
        }
    }
}

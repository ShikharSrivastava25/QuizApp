package com.example.quizapp.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quizapp.R
import com.example.quizapp.presentation.util.Dimens


@Preview(showBackground = true)
@Composable
fun Prev() {
    val list = listOf("Item 1", "Item 2")
    AppDropDownMenu(menuName = "Drop Down", menuList = list, text = "item 1", onDropDownClick = {})
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppDropDownMenu(
    menuName: String,
    menuList: List<String>,
    text : String,
    onDropDownClick : (String) -> Unit
) {
    var isExpanded by remember { mutableStateOf(false) }
//    var selectedText by remember { mutableStateOf(menuList[0]) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = Dimens.MediumPadding)
//            .background(Color.Black)
    ) {
        Text(
            text = menuName,
            style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.Bold
            ),
            color = colorResource(id = R.color.blue_grey)
        )

        Spacer(modifier = Modifier.height(Dimens.SmallSpacerHeight))

        ExposedDropdownMenuBox(
            expanded = isExpanded,
            onExpandedChange = { isExpanded = !isExpanded }
        ) {
            OutlinedTextField(
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth(),
                value = text,
                onValueChange = {},
                readOnly = true,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
                },
                colors = ExposedDropdownMenuDefaults.outlinedTextFieldColors(
                    focusedTextColor = colorResource(id = R.color.blue_grey),
                    unfocusedTrailingIconColor = colorResource(id = R.color.orange),
                    focusedTrailingIconColor = colorResource(id = R.color.orange),
                    focusedBorderColor = colorResource(id = R.color.dark_slate_blue),
                    unfocusedBorderColor = colorResource(id = R.color.dark_slate_blue),
                    unfocusedContainerColor = colorResource(id = R.color.dark_slate_blue)
                ),
                shape = RoundedCornerShape(15.dp)
            )

            DropdownMenu(
                modifier = Modifier
                    .background(colorResource(id = R.color.mid_night_blue)),
                expanded = isExpanded,
                onDismissRequest = { isExpanded = false }
            ) {
                menuList.forEachIndexed { index : Int, text : String ->
                    DropdownMenuItem(
                        text = {
                            Text(text = text, color = colorResource(id = R.color.blue_grey))
                        },
                        onClick = {
                            onDropDownClick(menuList[index])
                            isExpanded = false
                        },
                        contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                    )
                }
            }
        }
    }
}

package com.shinkatech.renshugo.presentation.screen.jlptLevelScreen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.visible
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomLevelSelectCardView(
    jpLevel: String,
    levelTitle: String,
    description: String,
    wordNum: String,
    grammarNum: String,
    isSelected: Boolean,
    onClick: () -> Unit = {}
) {

    val haptic = LocalHapticFeedback.current


    LaunchedEffect(isSelected) {
        if (isSelected) {
            // haplic feedback
            haptic.performHapticFeedback(HapticFeedbackType.LongPress)
        }
    }

    OutlinedCard(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(
                onClick = onClick
            )
            .semantics {
                role = Role.RadioButton
            },
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(
            width = if (isSelected) 2.dp else 1.dp,
            color = if (isSelected) MaterialTheme.colorScheme.primary
            else MaterialTheme.colorScheme.outlineVariant
        ),
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected) MaterialTheme.colorScheme.primary.copy(alpha = 0.1f)
            else MaterialTheme.colorScheme.background
        ),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),

            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(percent = 100))
                    .background(if (isSelected) MaterialTheme.colorScheme.primary else Color.LightGray)
            ) {
                Text(
                    text = jpLevel,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    color = if (isSelected) Color.White else Color.Black,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(8.dp)
                )
            }

            Spacer(modifier = Modifier.weight(0.1f))

            // two str
            Column(
                modifier = Modifier.weight(2f), horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = levelTitle,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontSize = 22.sp
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = description,
                    color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f),
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "$wordNum Words",
                    color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f),
                    modifier = Modifier
                        .clip(RoundedCornerShape(6.dp))
                        .background(
                            if (isSelected) MaterialTheme.colorScheme.background else Color.LightGray.copy(
                                alpha = 0.1f
                            )
                        )
                        .padding(vertical = 2.dp, horizontal = 6.dp),
                    fontSize = 14.sp

                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "$grammarNum Grammars",
                    color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f),
                    modifier = Modifier
                        .clip(RoundedCornerShape(6.dp))
                        .background(
                            if (isSelected) MaterialTheme.colorScheme.background else Color.LightGray.copy(
                                alpha = 0.1f
                            )
                        )
                        .padding(vertical = 2.dp, horizontal = 6.dp),
                    fontSize = 14.sp

                )

            }

            Spacer(modifier = Modifier.weight(0.2f))

            //one svg or icon
            if (isSelected) {
                Icon(
                    imageVector = Icons.Default.CheckCircle,
                    tint = MaterialTheme.colorScheme.primary,
                    contentDescription = "check box for selected language",
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}

@Preview(
    name = "Selected",
    showBackground = true
)
@Preview(
    name = "Unselected",
    showBackground = true
)
@Composable
fun CustomLanguageCardPreview() {

    Column {
        CustomLevelSelectCardView(
            jpLevel = "N5",
            levelTitle = "Beginner",
            description = "basic greeting, simple sentence",
            wordNum = "120",
            grammarNum = "60",
            isSelected = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        CustomLevelSelectCardView(
            jpLevel = "N5",
            levelTitle = "Beginner",
            description = "basic greeting, simple sentence",
            wordNum = "120",
            grammarNum = "60",
            isSelected = false
        )
    }
}
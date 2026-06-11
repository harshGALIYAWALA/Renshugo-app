package com.shinkatech.renshugo.presentation.screen.jlptLevelScreen.components

import android.R
import android.widget.Space
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
import androidx.compose.foundation.layout.width
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
    isSelected: () -> Boolean,
    onClick: () -> Unit = {}
){

    val haptic = LocalHapticFeedback.current
    val selected = isSelected()


    LaunchedEffect(selected) {
        if (selected) {
            // haplic feedback
            haptic.performHapticFeedback(HapticFeedbackType.LongPress)
        }
    }

    OutlinedCard(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(12.dp))
            .fillMaxWidth()
            .clickable(
                onClick = onClick
            )
            .semantics {
                role = Role.RadioButton
            },
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(
            width = if (selected) 2.dp else 1.dp,
            color = if (selected) MaterialTheme.colorScheme.primary
            else MaterialTheme.colorScheme.outlineVariant
        ),
        colors = CardDefaults.cardColors(
            containerColor = if (selected) MaterialTheme.colorScheme.primary.copy(alpha = 0.1f)
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
                    .clip(RoundedCornerShape(50))
                    .background(if (selected) MaterialTheme.colorScheme.primary else Color.LightGray)
            ) {
                Text(
                    text = "N5",
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    color = if (selected) Color.White else Color.Black,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(8.dp)
                )
            }

            Spacer(modifier = Modifier.weight(0.2f))

            // two str
            Column(
                modifier = Modifier.weight(2f), horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Beginner",
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontSize = 18.sp
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "basic greeting, simple sentence",
                    color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f),
                )
                Spacer(modifier = Modifier.height(6.dp))
                Row{
                    Text(
                        text = "$wordNum Words",
                        color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f),
                        modifier = Modifier
                            .clip(RoundedCornerShape(6.dp))
                            .background(if (selected) MaterialTheme.colorScheme.background else Color.LightGray)
                            .padding(vertical = 2.dp, horizontal = 6.dp)

                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        text = "$wordNum Words",
                        color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f),
                        modifier = Modifier
                            .clip(RoundedCornerShape(6.dp))
                            .background(if (selected) MaterialTheme.colorScheme.background else Color.LightGray)
                            .padding(vertical = 2.dp, horizontal = 6.dp)

                    )
                }
            }

            //one svg or icon
            if (selected) {
                Icon(
                    modifier = Modifier.weight(1f),
                    imageVector = Icons.Default.CheckCircle,
                    tint = MaterialTheme.colorScheme.primary,
                    contentDescription = "check box for selected language"
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
            isSelected = { true }
        )

        Spacer(modifier = Modifier.height(16.dp))

        CustomLevelSelectCardView(
            jpLevel = "N5",
            levelTitle = "Beginner",
            description = "basic greeting, simple sentence",
            wordNum = "120",
            grammarNum = "60",
            isSelected = { false }
        )
    }
}
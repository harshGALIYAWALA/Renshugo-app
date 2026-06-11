package com.shinkatech.renshugo.presentation.screen.languageScreen.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.selected
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomLanguageSelectedCardView(
    language: String,
    translatedLanguage: String,
    isSelected: () -> Boolean,
    onClick: () -> Unit = {}
) {

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
            .semantics{
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
            // two str
            Column(
                modifier = Modifier.weight(1f), horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = language,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontSize = 18.sp
                )

                Text(
                    text = translatedLanguage,
                    color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f),
                    fontSize = 14.sp
                )
            }

            //one svg or icon
            if (selected) {
                Icon(
                    imageVector = Icons.Default.CheckCircle,
                    tint = MaterialTheme.colorScheme.primary,
                    contentDescription = "check box for selected language"
                )
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun CustomLanguageSelectedCardViewPreview() {
//    CustomLanguageSelectedCardView(
//        language = "English",
//        translatedLanguage = "English",
//        isSelected = true
//    )
//}
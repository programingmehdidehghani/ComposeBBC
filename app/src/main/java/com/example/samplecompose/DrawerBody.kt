package com.example.samplecompose

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kotlinx.coroutines.CoroutineScope

@Composable
fun DrawerBody(
    menuItems: List<MenuItem>,
    scaffoldState: ScaffoldState,
    scope: CoroutineScope,
    modifier: Modifier = Modifier,
    onItemClick: (MenuItem) -> Unit
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(menuItems) { item ->
            DrawerItem(
                item,
                modifier = modifier
            ) {
                scope.launch {
                    scaffoldState.drawerState.close()
                }
                onItemClick(item)
            }
        }
    }
}
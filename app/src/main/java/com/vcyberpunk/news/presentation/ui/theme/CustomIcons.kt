package com.vcyberpunk.news.presentation.ui.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

object CustomIcons {

    @Suppress("CheckReturnValue")
    val Refresh: ImageVector
        get() {
            if (_Refresh != null) {
                return _Refresh!!
            }
            _Refresh =
                ImageVector.Builder(
                    name = "refresh",
                    defaultWidth = 24.dp,
                    defaultHeight = 24.dp,
                    viewportWidth = 24f,
                    viewportHeight = 24f,
                )
                    .apply {
                        path(
                            fill = SolidColor(Color.Black),
                            fillAlpha = 1f,
                            stroke = null,
                            strokeAlpha = 1f,
                            strokeLineWidth = 1f,
                            strokeLineCap = StrokeCap.Butt,
                            strokeLineJoin = StrokeJoin.Bevel,
                            strokeLineMiter = 1f,
                            pathFillType = PathFillType.NonZero,
                        ) {
                            moveTo(12f, 20f)
                            quadTo(8.65f, 20f, 6.33f, 17.68f)
                            reflectiveQuadTo(4f, 12f)
                            reflectiveQuadTo(6.33f, 6.32f)
                            reflectiveQuadTo(12f, 4f)
                            quadToRelative(1.73f, 0f, 3.3f, 0.71f)
                            quadTo(16.88f, 5.43f, 18f, 6.75f)
                            verticalLineTo(4f)
                            horizontalLineToRelative(2f)
                            verticalLineToRelative(7f)
                            horizontalLineTo(13f)
                            verticalLineTo(9f)
                            horizontalLineToRelative(4.2f)
                            quadTo(16.4f, 7.6f, 15.01f, 6.8f)
                            reflectiveQuadTo(12f, 6f)
                            quadTo(9.5f, 6f, 7.75f, 7.75f)
                            reflectiveQuadTo(6f, 12f)
                            reflectiveQuadToRelative(1.75f, 4.25f)
                            reflectiveQuadTo(12f, 18f)
                            quadToRelative(1.93f, 0f, 3.48f, -1.1f)
                            reflectiveQuadTo(17.65f, 14f)
                            horizontalLineToRelative(2.1f)
                            quadToRelative(-0.7f, 2.65f, -2.85f, 4.32f)
                            reflectiveQuadTo(12f, 20f)
                            close()
                        }
                    }
                    .build()
            return _Refresh!!
        }

    private var _Refresh: ImageVector? = null

    @Suppress("CheckReturnValue")
    val Clear: ImageVector
        get() {
            if (_Clear != null) {
                return _Clear!!
            }
            _Clear =
                ImageVector.Builder(
                    name = "close",
                    defaultWidth = 24.dp,
                    defaultHeight = 24.dp,
                    viewportWidth = 24f,
                    viewportHeight = 24f,
                )
                    .apply {
                        path(
                            fill = SolidColor(Color.Black),
                            fillAlpha = 1f,
                            stroke = null,
                            strokeAlpha = 1f,
                            strokeLineWidth = 1f,
                            strokeLineCap = StrokeCap.Butt,
                            strokeLineJoin = StrokeJoin.Bevel,
                            strokeLineMiter = 1f,
                            pathFillType = PathFillType.NonZero,
                        ) {
                            moveTo(6.4f, 19f)
                            lineTo(5f, 17.6f)
                            lineTo(10.6f, 12f)
                            lineTo(5f, 6.4f)
                            lineTo(6.4f, 5f)
                            lineTo(12f, 10.6f)
                            lineTo(17.6f, 5f)
                            lineTo(19f, 6.4f)
                            lineTo(13.4f, 12f)
                            lineTo(19f, 17.6f)
                            lineTo(17.6f, 19f)
                            lineTo(12f, 13.4f)
                            lineTo(6.4f, 19f)
                            close()
                        }
                    }
                    .build()
            return _Clear!!
        }

    private var _Clear: ImageVector? = null

    @Suppress("CheckReturnValue")
    val Settings: ImageVector
        get() {
            if (_Settings != null) {
                return _Settings!!
            }
            _Settings =
                ImageVector.Builder(
                    name = "settings",
                    defaultWidth = 24.dp,
                    defaultHeight = 24.dp,
                    viewportWidth = 24f,
                    viewportHeight = 24f,
                )
                    .apply {
                        path(
                            fill = SolidColor(Color.Black),
                            fillAlpha = 1f,
                            stroke = null,
                            strokeAlpha = 1f,
                            strokeLineWidth = 1f,
                            strokeLineCap = StrokeCap.Butt,
                            strokeLineJoin = StrokeJoin.Bevel,
                            strokeLineMiter = 1f,
                            pathFillType = PathFillType.NonZero,
                        ) {
                            moveTo(9.25f, 22f)
                            lineTo(8.85f, 18.8f)
                            quadTo(8.53f, 18.68f, 8.24f, 18.5f)
                            reflectiveQuadTo(7.68f, 18.13f)
                            lineTo(4.7f, 19.38f)
                            lineTo(1.95f, 14.63f)
                            lineTo(4.53f, 12.68f)
                            quadTo(4.5f, 12.5f, 4.5f, 12.34f)
                            quadToRelative(0f, -0.16f, 0f, -0.34f)
                            reflectiveQuadToRelative(0f, -0.34f)
                            reflectiveQuadTo(4.53f, 11.33f)
                            lineTo(1.95f, 9.38f)
                            lineTo(4.7f, 4.63f)
                            lineTo(7.68f, 5.88f)
                            quadTo(7.95f, 5.68f, 8.25f, 5.5f)
                            reflectiveQuadTo(8.85f, 5.2f)
                            lineTo(9.25f, 2f)
                            horizontalLineToRelative(5.5f)
                            lineToRelative(0.4f, 3.2f)
                            quadToRelative(0.33f, 0.13f, 0.61f, 0.3f)
                            reflectiveQuadToRelative(0.56f, 0.38f)
                            lineTo(19.3f, 4.63f)
                            lineToRelative(2.75f, 4.75f)
                            lineToRelative(-2.57f, 1.95f)
                            quadToRelative(0.02f, 0.18f, 0.02f, 0.34f)
                            reflectiveQuadToRelative(0f, 0.34f)
                            reflectiveQuadToRelative(0f, 0.34f)
                            reflectiveQuadToRelative(-0.05f, 0.34f)
                            lineToRelative(2.57f, 1.95f)
                            lineToRelative(-2.75f, 4.75f)
                            lineTo(16.33f, 18.13f)
                            quadToRelative(-0.27f, 0.2f, -0.57f, 0.38f)
                            reflectiveQuadToRelative(-0.6f, 0.3f)
                            lineTo(14.75f, 22f)
                            horizontalLineTo(9.25f)
                            close()
                            moveToRelative(2.8f, -6.5f)
                            quadToRelative(1.45f, 0f, 2.47f, -1.03f)
                            reflectiveQuadTo(15.55f, 12f)
                            reflectiveQuadTo(14.53f, 9.52f)
                            reflectiveQuadTo(12.05f, 8.5f)
                            quadToRelative(-1.47f, 0f, -2.49f, 1.02f)
                            reflectiveQuadTo(8.55f, 12f)
                            reflectiveQuadToRelative(1.01f, 2.47f)
                            reflectiveQuadToRelative(2.49f, 1.03f)
                            close()
                        }
                    }
                    .build()
            return _Settings!!
        }

    private var _Settings: ImageVector? = null

    @Suppress("CheckReturnValue")
    val Add: ImageVector
        get() {
            if (_Add != null) {
                return _Add!!
            }
            _Add =
                ImageVector.Builder(
                    name = "add",
                    defaultWidth = 24.dp,
                    defaultHeight = 24.dp,
                    viewportWidth = 24f,
                    viewportHeight = 24f,
                )
                    .apply {
                        path(
                            fill = SolidColor(Color.Black),
                            fillAlpha = 1f,
                            stroke = null,
                            strokeAlpha = 1f,
                            strokeLineWidth = 1f,
                            strokeLineCap = StrokeCap.Butt,
                            strokeLineJoin = StrokeJoin.Bevel,
                            strokeLineMiter = 1f,
                            pathFillType = PathFillType.NonZero,
                        ) {
                            moveTo(11f, 13f)
                            horizontalLineTo(5f)
                            verticalLineTo(11f)
                            horizontalLineToRelative(6f)
                            verticalLineTo(5f)
                            horizontalLineToRelative(2f)
                            verticalLineToRelative(6f)
                            horizontalLineToRelative(6f)
                            verticalLineToRelative(2f)
                            horizontalLineTo(13f)
                            verticalLineToRelative(6f)
                            horizontalLineTo(11f)
                            verticalLineTo(13f)
                            close()
                        }
                    }
                    .build()
            return _Add!!
        }

    private var _Add: ImageVector? = null

    @Suppress("CheckReturnValue")
    val OpenInNew: ImageVector
        get() {
            if (_OpenInNew != null) {
                return _OpenInNew!!
            }
            _OpenInNew =
                ImageVector.Builder(
                    name = "open_in_new",
                    defaultWidth = 24.dp,
                    defaultHeight = 24.dp,
                    viewportWidth = 24f,
                    viewportHeight = 24f,
                )
                    .apply {
                        path(
                            fill = SolidColor(Color.Black),
                            fillAlpha = 1f,
                            stroke = null,
                            strokeAlpha = 1f,
                            strokeLineWidth = 1f,
                            strokeLineCap = StrokeCap.Butt,
                            strokeLineJoin = StrokeJoin.Bevel,
                            strokeLineMiter = 1f,
                            pathFillType = PathFillType.NonZero,
                        ) {
                            moveTo(5f, 21f)
                            quadTo(4.18f, 21f, 3.59f, 20.41f)
                            reflectiveQuadTo(3f, 19f)
                            verticalLineTo(5f)
                            quadTo(3f, 4.17f, 3.59f, 3.59f)
                            reflectiveQuadTo(5f, 3f)
                            horizontalLineToRelative(7f)
                            verticalLineTo(5f)
                            horizontalLineTo(5f)
                            verticalLineTo(19f)
                            horizontalLineTo(19f)
                            verticalLineTo(12f)
                            horizontalLineToRelative(2f)
                            verticalLineToRelative(7f)
                            quadToRelative(0f, 0.82f, -0.59f, 1.41f)
                            reflectiveQuadTo(19f, 21f)
                            horizontalLineTo(5f)
                            close()
                            moveTo(9.7f, 15.7f)
                            lineTo(8.3f, 14.3f)
                            lineTo(17.6f, 5f)
                            horizontalLineTo(14f)
                            verticalLineTo(3f)
                            horizontalLineToRelative(7f)
                            verticalLineToRelative(7f)
                            horizontalLineTo(19f)
                            verticalLineTo(6.4f)
                            lineTo(9.7f, 15.7f)
                            close()
                        }
                    }
                    .build()
            return _OpenInNew!!
        }

    private var _OpenInNew: ImageVector? = null

    @Suppress("CheckReturnValue")
    val Share: ImageVector
        get() {
            if (_Share != null) {
                return _Share!!
            }
            _Share =
                ImageVector.Builder(
                    name = "share",
                    defaultWidth = 24.dp,
                    defaultHeight = 24.dp,
                    viewportWidth = 24f,
                    viewportHeight = 24f,
                )
                    .apply {
                        path(
                            fill = SolidColor(Color.Black),
                            fillAlpha = 1f,
                            stroke = null,
                            strokeAlpha = 1f,
                            strokeLineWidth = 1f,
                            strokeLineCap = StrokeCap.Butt,
                            strokeLineJoin = StrokeJoin.Bevel,
                            strokeLineMiter = 1f,
                            pathFillType = PathFillType.NonZero,
                        ) {
                            moveTo(17f, 22f)
                            quadToRelative(-1.25f, 0f, -2.13f, -0.88f)
                            reflectiveQuadTo(14f, 19f)
                            quadToRelative(0f, -0.15f, 0.08f, -0.7f)
                            lineTo(7.05f, 14.2f)
                            quadToRelative(-0.4f, 0.38f, -0.93f, 0.59f)
                            reflectiveQuadTo(5f, 15f)
                            quadTo(3.75f, 15f, 2.88f, 14.13f)
                            reflectiveQuadTo(2f, 12f)
                            reflectiveQuadTo(2.88f, 9.88f)
                            reflectiveQuadTo(5f, 9f)
                            quadTo(5.6f, 9f, 6.13f, 9.21f)
                            reflectiveQuadTo(7.05f, 9.8f)
                            lineTo(14.08f, 5.7f)
                            quadTo(14.03f, 5.52f, 14.01f, 5.36f)
                            reflectiveQuadTo(14f, 5f)
                            quadTo(14f, 3.75f, 14.88f, 2.88f)
                            reflectiveQuadTo(17f, 2f)
                            reflectiveQuadToRelative(2.13f, 0.88f)
                            reflectiveQuadTo(20f, 5f)
                            reflectiveQuadTo(19.13f, 7.13f)
                            reflectiveQuadTo(17f, 8f)
                            quadTo(16.4f, 8f, 15.88f, 7.79f)
                            reflectiveQuadTo(14.95f, 7.2f)
                            lineTo(7.93f, 11.3f)
                            quadToRelative(0.05f, 0.18f, 0.06f, 0.34f)
                            reflectiveQuadTo(8f, 12f)
                            reflectiveQuadTo(7.99f, 12.36f)
                            reflectiveQuadTo(7.93f, 12.7f)
                            lineToRelative(7.03f, 4.1f)
                            quadToRelative(0.4f, -0.38f, 0.92f, -0.59f)
                            reflectiveQuadTo(17f, 16f)
                            quadToRelative(1.25f, 0f, 2.13f, 0.88f)
                            reflectiveQuadTo(20f, 19f)
                            reflectiveQuadToRelative(-0.88f, 2.13f)
                            reflectiveQuadTo(17f, 22f)
                            close()
                        }
                    }
                    .build()
            return _Share!!
        }

    private var _Share: ImageVector? = null

    @Suppress("CheckReturnValue")
    val ArrowBack: ImageVector
        get() {
            if (_ArrowBack != null) {
                return _ArrowBack!!
            }
            _ArrowBack =
                ImageVector.Builder(
                    name = "arrow_back",
                    defaultWidth = 24.dp,
                    defaultHeight = 24.dp,
                    viewportWidth = 24f,
                    viewportHeight = 24f,
                )
                    .apply {
                        path(
                            fill = SolidColor(Color.Black),
                            fillAlpha = 1f,
                            stroke = null,
                            strokeAlpha = 1f,
                            strokeLineWidth = 1f,
                            strokeLineCap = StrokeCap.Butt,
                            strokeLineJoin = StrokeJoin.Bevel,
                            strokeLineMiter = 1f,
                            pathFillType = PathFillType.NonZero,
                        ) {
                            moveTo(7.83f, 13f)
                            lineToRelative(5.6f, 5.6f)
                            lineTo(12f, 20f)
                            lineTo(4f, 12f)
                            lineTo(12f, 4f)
                            lineToRelative(1.43f, 1.4f)
                            lineTo(7.83f, 11f)
                            horizontalLineTo(20f)
                            verticalLineToRelative(2f)
                            horizontalLineTo(7.83f)
                            close()
                        }
                    }
                    .build()
            return _ArrowBack!!
        }

    private var _ArrowBack: ImageVector? = null


}
package com.anonymous.appilogue.repository

import com.anonymous.appilogue.model.ReviewedApp
import javax.inject.Inject

class FakeAppRepository @Inject constructor() : AppRepository {
    override fun getBlackHoleApps(): List<ReviewedApp> {
        return listOf(
            ReviewedApp(
                "V라이브",
                "https://obj-sg.thewiki.kr/data/ebb88cec9db4eb9dbcec9db4ebb88c20ec9584ec9db4ecbd982e706e67.png"
            ),
            ReviewedApp(
                "페이스북",
               "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1b/Facebook_icon.svg/1200px-Facebook_icon.svg.png"
            ),
            ReviewedApp(
                "인스타그램",
                "https://mblogthumb-phinf.pstatic.net/MjAxOTAxMDlfNTMg/MDAxNTQ3MDE4MzI4NDIy.O4sP_QpdWO9GiVpfkp92MLvnMGBRzm82q3VhEfz8GMQg.kTDiopuqqvHXHZJ784QiGWX-DwGaEj3mvQ04aCqPC0Qg.PNG.designpress2016/Instagram_logo_2016.png?type=w800"
            ),
            ReviewedApp(
                "라인",
                "https://upload.wikimedia.org/wikipedia/commons/2/2e/LINE_New_App_Icon_%282020-12%29.png"
            ),
            ReviewedApp(
                "카카오톡",
                "data:image/png;base64,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"
            ),
            ReviewedApp(
                "카카오톡",
                "data:image/png;base64,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"
            ),
            ReviewedApp(
                "V라이브",
                "https://obj-sg.thewiki.kr/data/ebb88cec9db4eb9dbcec9db4ebb88c20ec9584ec9db4ecbd982e706e67.png"
            ),
            ReviewedApp(
                "페이스북",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1b/Facebook_icon.svg/1200px-Facebook_icon.svg.png"
            ),
            ReviewedApp(
                "인스타그램",
                "https://mblogthumb-phinf.pstatic.net/MjAxOTAxMDlfNTMg/MDAxNTQ3MDE4MzI4NDIy.O4sP_QpdWO9GiVpfkp92MLvnMGBRzm82q3VhEfz8GMQg.kTDiopuqqvHXHZJ784QiGWX-DwGaEj3mvQ04aCqPC0Qg.PNG.designpress2016/Instagram_logo_2016.png?type=w800"
            ),
            ReviewedApp(
                "라인",
                "https://upload.wikimedia.org/wikipedia/commons/2/2e/LINE_New_App_Icon_%282020-12%29.png"
            ),
            ReviewedApp(
                "라인",
                "https://upload.wikimedia.org/wikipedia/commons/2/2e/LINE_New_App_Icon_%282020-12%29.png"
            ),
            ReviewedApp(
                "카카오톡",
                "data:image/png;base64,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"
            ),
            ReviewedApp(
                "V라이브",
                "https://obj-sg.thewiki.kr/data/ebb88cec9db4eb9dbcec9db4ebb88c20ec9584ec9db4ecbd982e706e67.png"
            ),
            ReviewedApp(
                "페이스북",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1b/Facebook_icon.svg/1200px-Facebook_icon.svg.png"
            ),
            ReviewedApp(
                "인스타그램",
                "https://mblogthumb-phinf.pstatic.net/MjAxOTAxMDlfNTMg/MDAxNTQ3MDE4MzI4NDIy.O4sP_QpdWO9GiVpfkp92MLvnMGBRzm82q3VhEfz8GMQg.kTDiopuqqvHXHZJ784QiGWX-DwGaEj3mvQ04aCqPC0Qg.PNG.designpress2016/Instagram_logo_2016.png?type=w800"
            ),
        )
    }

    override fun getWhiteHoleApps(): List<ReviewedApp> {
        return listOf(
            ReviewedApp(
                "인스타그램",
                "https://mblogthumb-phinf.pstatic.net/MjAxOTAxMDlfNTMg/MDAxNTQ3MDE4MzI4NDIy.O4sP_QpdWO9GiVpfkp92MLvnMGBRzm82q3VhEfz8GMQg.kTDiopuqqvHXHZJ784QiGWX-DwGaEj3mvQ04aCqPC0Qg.PNG.designpress2016/Instagram_logo_2016.png?type=w800"
            ),
            ReviewedApp(
                "V라이브",
                "https://obj-sg.thewiki.kr/data/ebb88cec9db4eb9dbcec9db4ebb88c20ec9584ec9db4ecbd982e706e67.png"
            ),
            ReviewedApp(
                "페이스북",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1b/Facebook_icon.svg/1200px-Facebook_icon.svg.png"
            ),
            ReviewedApp(
                "인스타그램",
                "https://mblogthumb-phinf.pstatic.net/MjAxOTAxMDlfNTMg/MDAxNTQ3MDE4MzI4NDIy.O4sP_QpdWO9GiVpfkp92MLvnMGBRzm82q3VhEfz8GMQg.kTDiopuqqvHXHZJ784QiGWX-DwGaEj3mvQ04aCqPC0Qg.PNG.designpress2016/Instagram_logo_2016.png?type=w800"
            ),
            ReviewedApp(
                "라인",
                "https://upload.wikimedia.org/wikipedia/commons/2/2e/LINE_New_App_Icon_%282020-12%29.png"
            ),
            ReviewedApp(
                "카카오톡",
                "data:image/png;base64,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"
            ),
            ReviewedApp(
                "카카오톡",
                "data:image/png;base64,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"
            ),
            ReviewedApp(
                "V라이브",
                "https://obj-sg.thewiki.kr/data/ebb88cec9db4eb9dbcec9db4ebb88c20ec9584ec9db4ecbd982e706e67.png"
            ),
            ReviewedApp(
                "페이스북",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1b/Facebook_icon.svg/1200px-Facebook_icon.svg.png"
            ),
            ReviewedApp(
                "인스타그램",
                "https://mblogthumb-phinf.pstatic.net/MjAxOTAxMDlfNTMg/MDAxNTQ3MDE4MzI4NDIy.O4sP_QpdWO9GiVpfkp92MLvnMGBRzm82q3VhEfz8GMQg.kTDiopuqqvHXHZJ784QiGWX-DwGaEj3mvQ04aCqPC0Qg.PNG.designpress2016/Instagram_logo_2016.png?type=w800"
            ),
            ReviewedApp(
                "라인",
                "https://upload.wikimedia.org/wikipedia/commons/2/2e/LINE_New_App_Icon_%282020-12%29.png"
            ),
            ReviewedApp(
                "라인",
                "https://upload.wikimedia.org/wikipedia/commons/2/2e/LINE_New_App_Icon_%282020-12%29.png"
            ),
            ReviewedApp(
                "카카오톡",
                "data:image/png;base64,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"
            ),
            ReviewedApp(
                "V라이브",
                "https://obj-sg.thewiki.kr/data/ebb88cec9db4eb9dbcec9db4ebb88c20ec9584ec9db4ecbd982e706e67.png"
            ),
            ReviewedApp(
                "페이스북",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1b/Facebook_icon.svg/1200px-Facebook_icon.svg.png"
            ),
        )
    }
}
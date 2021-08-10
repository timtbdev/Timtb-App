object Libs {

    object Kotlin {

        val Stdlib: String
            get() = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.Kotlin}"

        val Coroutines: String
            get() = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.Coroutines}"

    }

    object Google {
        val Material: String
            get() = "com.google.android.material:material:${Versions.Material}"

        object Hilt {
            val Android: String
                get() = "com.google.dagger:hilt-android:${Versions.Hilt}"
            val Compiler: String
                get() = "com.google.dagger:hilt-android-compiler:${Versions.Hilt}"
            val Navigation: String =
                "androidx.hilt:hilt-navigation-compose:1.0.0-alpha01${Versions.HiltNavigation}"

        }

        object Accompanist {
            val Coil: String
                get() = "com.google.accompanist:accompanist-coil:${Versions.Accompanist}"
            val Pager: String
                get() = "com.google.accompanist:accompanist-pager:${Versions.Accompanist}"
            val Indicator: String
                get() = "com.google.accompanist:accompanist-pager-indicators:${Versions.Accompanist}"
            val FlowLayout: String
                get() = "com.google.accompanist:accompanist-flowlayout:${Versions.Accompanist}"
        }
    }

    object AndroidX {

        val Ktx: String
            get() = "androidx.core:core-ktx:${Versions.AndroidX}"

        val AppCompat: String
            get() = "androidx.appcompat:appcompat:${Versions.AppCompat}"

        val ConstraintLayoutCompose: String
            get() = "androidx.constraintlayout:constraintlayout-compose${Versions.ConstraintLayoutCompose}"

        val DataStorePreference: String
            get() = "androidx.datastore:datastore-preferences:${Versions.DataStore}"

        object Compose {
            val Ui: String
                get() = "androidx.compose.ui:ui:${Versions.Compose}"
            val UiTooling: String
                get() = "androidx.compose.ui:ui-tooling:${Versions.Compose}"
            val Foundation: String
                get() = "androidx.compose.foundation:foundation:${Versions.Compose}"
            val Material: String
                get() = "androidx.compose.material:material:${Versions.Compose}"
            val Icons: String
                get() = "androidx.compose.material:material-icons-core:${Versions.Compose}"
            val IconsExt: String
                get() = "androidx.compose.material:material-icons-extended:${Versions.Compose}"
            val Activity: String
                get() = "androidx.activity:activity-compose:${Versions.ComposeActivity}"
            val ViewModel: String
                get() = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.ComposeViewModel}"
            val UiTest: String
                get() = "androidx.compose.ui:ui-test-junit4:${Versions.Compose}"

        }

        val Navigation: String
            get() = "androidx.navigation:navigation-compose:${Versions.NavigationCompose}"

        object Room {
            val Runtime: String
                get() = "androidx.room:room-runtime:${Versions.Room}"
            val Ktx: String
                get() = "androidx.room:room-ktx:${Versions.Room}"
            val Kapt: String
                get() = "androidx.room:room-compiler:${Versions.Room}"

        }

        val Work: String
            get() = "androidx.work:work-runtime-ktx:${Versions.Work}"
    }

    object Firebase {
        val Performance: String
            get() = "com.google.firebase:firebase-perf:${Versions.FirebasePerf}"
        val Analytics: String
            get() = "com.google.firebase:firebase-analytics-ktx:${Versions.FirebaseAnalytics}"
        val Crashlytics: String
            get() = "com.google.firebase:firebase-crashlytics:${Versions.FirebaseCrash}"
    }

    object Square {
        val Retrofit: String
            get() = "com.squareup.retrofit2:retrofit:${Versions.Retrofit}"
        val GsonConverter: String
            get() = "com.squareup.retrofit2:converter-gson:${Versions.Retrofit}"
        val OkHttp: String
            get() = "com.google.code.gson:gson:${Versions.OkHttp}"
        val Gson: String
            get() = "com.squareup.okhttp3:logging-interceptor:${Versions.Gson}"
        val LeakCanary: String
            get() = "com.squareup.leakcanary:leakcanary-android:${Versions.LeakCanary}"
    }

    object Junit {
        val API: String
            get() = "org.junit.jupiter:junit-jupiter-api:${Versions.Junit}"
        val Params: String
            get() = "org.junit.jupiter:junit-jupiter-params:${Versions.Junit}"
        val Engine: String
            get() = "org.junit.jupiter:junit-jupiter-engine:${Versions.Junit}"

    }

    val Mockk: String
        get() = "io.mockk:mockk:${Versions.Mockk}"
    val MockkAndroid: String
        get() = "io.mockk:mockk-android:${Versions.Mockk}"
}
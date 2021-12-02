import org.gradle.api.artifacts.dsl.DependencyHandler

object AppDependencies {

    private const val KOTLIN_STD_LIB =
        "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.KOTLIN_VERSION}"
    private const val APPCOMPAT = "androidx.appcompat:appcompat:${Versions.APP_COMPAT_VERSION}"
    private const val CORE_KTX = "androidx.core:core-ktx:${Versions.CORE_KTX_VERSION}"
    private const val EXT_JUNIT = "androidx.test.ext:junit:${Versions.EXT_JUNIT_VERSION}"
    private const val ESPRESSO_CORE =
        "androidx.test.espresso:espresso-core:${Versions.ESPRESSO_VERSION}"
    private const val MATERIAL = "com.google.android.material:material:${Versions.MATERIAL_VERSION}"
    private const val KOIN = "io.insert-koin:koin-android:${Versions.KOIN_VERSION}"
    private const val KOIN_EXT = "io.insert-koin:koin-android-ext:${Versions.KOIN_VERSION}"
    private const val COROUTINES =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES_VERSION}"
    private const val LIFECYCLE_VIEWMODEL_KTX =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFCECYCLE_VIEWMODEL_VERSION}"
    private const val LIVEDATA_KTX =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.LIFCECYCLE_VIEWMODEL_VERSION}"
    private const val LOGGING_INTERCEPTOR =
        "com.squareup.okhttp3:logging-interceptor:${Versions.LOGGING_INTERCEPTOR_VERSION}"
    private const val MOCKK = "io.mockk:mockk:${Versions.MOCKK_VERSION}"
    private const val JUNIT_JUPITER_API =
        "org.junit.jupiter:junit-jupiter-api:${Versions.JUNIT_VERSION}"
    private const val JUPITER_ENGINE =
        "org.junit.jupiter:junit-jupiter-engine:${Versions.JUNIT_VERSION}"
    private const val LIFECYCLE_RUNTIME_KTX =
        "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.LIFECYCLE_RUNTIME_KTX_VERSION}"
    private const val NAV_FRAGMENT_KTX =
        "androidx.navigation:navigation-fragment-ktx:${Versions.NAV_VERSION}"
    private const val NAV_UI_KTX = "androidx.navigation:navigation-ui-ktx:${Versions.NAV_VERSION}"
    private const val NAV_MODULE_SUPP =
        "androidx.navigation:navigation-dynamic-features-fragment:${Versions.NAV_VERSION}"
    private const val NAV_TESTING = "androidx.navigation:navigation-testing:${Versions.NAV_VERSION}"
    private const val FRAGMENT_KTX = "androidx.fragment:fragment-ktx:${Versions.FRAGMENT_VERSION}"
    private const val FRAGMENT_TESTING_KTX =
        "androidx.fragment:fragment-testing:${Versions.FRAGMENT_VERSION}"
    private const val DATASTORE = "androidx.datastore:datastore:${Versions.DATASTORE_VERSION}"
    private const val DATASTORE_CORE =
        "androidx.datastore:datastore-core:${Versions.DATASTORE_VERSION}"
    private const val DATASTORE_PROTOBUF =
        "com.google.protobuf:protobuf-javalite:${Versions.DATASTORE_PROTOBUF_VERSION}"
    private const val CONSTRAINT_LAYOUT =
        "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT_VERSION}"
    private const val LIFECYCLE_RUNTIME =
        "androidx.lifecycle:lifecycle-runtime:${Versions.LIFECYCLE_VERSION}"
    private const val LIFECYCLE_EXTENSIONS =
        "androidx.lifecycle:lifecycle-extensions:${Versions.LIFECYCLE_EXTENSIONS_VERSION}"
    private const val GSON = "com.google.code.gson:gson:${Versions.GSON_VERSION}"
    private const val ROOM = "androidx.room:room-runtime:${Versions.ROOM_VERSION}"

    private val navigationDependencies = arrayListOf<String>().apply {
        add(NAV_FRAGMENT_KTX)
        add(NAV_UI_KTX)
        add(NAV_MODULE_SUPP)
    }
    private val datastoreDependencies = arrayListOf<String>().apply {
        add(DATASTORE)
        add(DATASTORE_CORE)
        add(DATASTORE_PROTOBUF)
    }
    val appLibraries = arrayListOf<String>().apply {
        add(KOTLIN_STD_LIB)
        add(CORE_KTX)
        add(APPCOMPAT)
        add(MATERIAL)
        add(KOIN)
        add(KOIN_EXT)
        add(COROUTINES)
        add(LIFECYCLE_VIEWMODEL_KTX)
        add(LIFECYCLE_RUNTIME_KTX)
        add(FRAGMENT_KTX)
        add(CONSTRAINT_LAYOUT)
        addAll(navigationDependencies)
        addAll(datastoreDependencies)
        add(ROOM)
    }

    val androidTestLibraries = arrayListOf<String>().apply {
        add(EXT_JUNIT)
        add(ESPRESSO_CORE)
        add(MOCKK)
        add(JUNIT_JUPITER_API)
        add(NAV_TESTING)
        add(FRAGMENT_TESTING_KTX)
    }
    val testLibraries = arrayListOf<String>().apply {
        add(JUPITER_ENGINE)
        add(MOCKK)
    }
}

fun DependencyHandler.kapt(list: List<String>) {
    list.forEach { dependency ->
        add("kapt", dependency)
    }
}

fun DependencyHandler.implementation(list: List<String>) {
    list.forEach { dependency ->
        add("implementation", dependency)
    }
}

fun DependencyHandler.androidTestImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("androidTestImplementation", dependency)
    }
}

fun DependencyHandler.testImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("testImplementation", dependency)
    }
}
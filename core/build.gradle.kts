plugins {
    id("makeru.base-conventions")
    alias(libs.plugins.lombok)
}

dependencies {
    compileOnly(libs.jb.annotations)
}

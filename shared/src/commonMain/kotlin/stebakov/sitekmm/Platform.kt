package stebakov.sitekmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
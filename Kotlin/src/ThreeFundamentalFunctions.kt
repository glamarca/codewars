fun <T>unless(b : Boolean, funct : () -> T): T?{
    if(!b){
        funct()
    }
    return null
}

fun <T>until(cond: () -> Boolean, funct: () ->T): T?{
    while(!cond()){
        funct()
    }
    return null
}

fun <T>forceRun(funct: () -> T):T?{
    try {
        funct()
    } catch (e : Exception){

    } catch (e : Error) {

    }
    return null
}

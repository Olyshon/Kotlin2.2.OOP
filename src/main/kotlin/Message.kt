data class Message(
    var idMess: Int = 0,
    val idMesSender: Int = 0,
    var text: String,
    var isRead: Boolean = false
) {
    override fun toString(): String {
        return "Сообщение № $idMess от '$idMesSender': '$text'.  Прочитано - $isRead)"
    }
}
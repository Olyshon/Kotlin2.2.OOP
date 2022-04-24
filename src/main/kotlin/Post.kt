import java.time.Instant

data class Post(
    val id: Long = 0,              // Идентификатор записи.
    val ownerId: Int = 0,         //Идентификатор владельца стены, на которой размещена запись
    val fromId: Int = 0,          //Идентификатор автора записи (от чьего имени опубликована запись)
    val createdBy: Int = 0,       // Идентификатор администратора, который опубликовал запись (возвращается только для сообществ при запросе с ключом доступа администратора). Возвращается в записях, опубликованных менее 24 часов назад.
    val date: Instant = Instant.ofEpochMilli(1000000),            //Время публикации записи в формате unixtime.
    val text: String = "Hello",         //текст записи
    val replyOwnerId: Int? = 0,    //Идентификатор владельца записи, в ответ на которую была оставлена текущая
    val replyPostId: Int? = 0,     //Идентификатор записи, в ответ на которую была оставлена текущая
    val friendsOnly: Boolean = false, //1, если запись была создана с опцией «Только для друзей»
    val postType: String = "post",     //Тип записи, может принимать следующие значения: post, copy, reply, postpone, suggest.
    val signerId: Int? = 0,        //Идентификатор автора, если запись была опубликована от имени сообщества и подписана пользователем;
    val canPin: Boolean = true,      //Информация о том, может ли текущий пользователь закрепить запись (1 — может, 0 — не может).
    val canDelete: Boolean = true,   //Информация о том, может ли текущий пользователь удалить запись (1 — может, 0 — не может).
    val canEdit: Boolean = true,     //Информация о том, может ли текущий пользователь редактировать запись (1 — может, 0 — не может).
    val isPinned: Boolean = false,    //Информация о том, что запись закреплена.
    val markedAsAds: Boolean = false, //Информация о том, содержит ли запись отметку «реклама» (1 — да, 0 — нет).
    val isFavorite: Boolean = false,  //true, если объект добавлен в закладки у текущего пользователя.
    val postponedId: Boolean = false,  //Идентификатор отложенной записи. Это поле возвращается тогда, когда запись стояла на таймере
    val likes: Likes = Likes(0u, userLikes = false, canLike = true, canPublish = true),
    val comments: Comments = Comments(0u, can_post = true, groups_can_post = true, can_close = true, can_open = true),
    val views: Views = Views(count = 0u),
    val reposts: Reposts = Reposts(0u, userReposted = false),
    val copyright: Copyright? = Copyright(1, "", "", ""),
    val donut: Donut? = Donut(isDonut = false, 0, "", false, "", "", 1),
    val postSource: PostSource? = PostSource(type = "", platform = "", data = "", url = ""),
    val geo: Geo? = Geo(type = "", coordinates = "", place = ""),
    val copyHistory: Array<Post>? = emptyArray<Post>(),
    val attachment: Attachment
    // val attachment: Array<Attachment>? = null
) {
    class Likes(
        val count: UInt,       //число пользователей, которым понравилась запись;
        val userLikes: Boolean,     //наличие отметки «Мне нравится» от текущего пользователя (1 — есть, 0 — нет);
        val canLike: Boolean,       //информация о том, может ли текущий пользователь поставить отметку «Мне нравится» (1 — может, 0 — не может);
        val canPublish: Boolean    //информация о том, может ли текущий пользователь сделать репост записи (1 — может, 0 — не может).
    )

    class Comments(
        val count: UInt,         //количество комментариев;
        val can_post: Boolean,        //информация о том, может ли текущий пользователь комментировать запись (1 — может, 0 — не может);
        val groups_can_post: Boolean, //информация о том, могут ли сообщества комментировать запись;
        val can_close: Boolean,       //может ли текущий пользователь закрыть комментарии к записи;
        val can_open: Boolean         //может ли текущий пользователь открыть комментарии к записи.
    )

    class Views(                       //Информация о просмотрах записи. Объект с единственным полем:
        val count: UInt           //число просмотров записи.
    )

    class Reposts(                       // Информация о репостах записи («Рассказать друзьям»), объект с полями:
        val count: UInt = 0U,                  // число пользователей, скопировавших запись;
        val userReposted: Boolean = false        //наличие репоста от текущего пользователя (1 — есть, 0 — нет).
    )

    class Copyright(                  //Источник материала:
        val id: Int,
        val link: String,
        val name: String,
        val type: String
    )

    class Donut(                          //Информация о записи VK Donut:
        val isDonut: Boolean,            // запись доступна только платным подписчикам VK Donut;
        val paidDuration: Int,           // время, в течение которого запись будет доступна только платным подписчикам VK Donut;
        val placeholder: String,         // заглушка для пользователей, которые не оформили подписку VK Donut. Отображается вместо содержимого записи.
        val canPublishFreeCopy: Boolean, //можно ли открыть запись для всех пользователей, а не только подписчиков VK Donut;
        val edit_mode: String,           // информация о том, какие значения VK Donut можно изменить в записи. Возможные значения:
        val all: String,                 //всю информацию о VK Donut.
        val duration: Int                // время, в течение которого запись будет доступна только платным подписчикам VK Donut.
    )

    class PostSource(
        val type: String,
        val platform: String,
        val data: String,
        val url: String
    )

    class Geo(
        val type: String,
        val coordinates: String,
        val place: String
    )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Post

        if (id != other.id) return false
        if (ownerId != other.ownerId) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + ownerId
        return result
    }

}


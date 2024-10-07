import java.util.Scanner

class ArchiveMenu : Menu("Меню архивов") {
    private val archive = mutableListOf<Archive>()
    override val options: List<Pair<String, () -> Unit>>
        get() = listOf("Создать архив" to ::createArchive) + archive.map { it.name to { viewNotes(it) } }


    private fun createArchive() {
        println("Введите имя архива:")
        val name = Scanner(System.`in`).nextLine()
        if (name.isNotBlank()) {
            archive.add(Archive(name))
            println("Архив '$name' создан.")
        } else {
            println("Имя архива не может быть пустым.")
        }
    }

    private fun viewNotes(archive: Archive) {
        val noteMenu = NoteMenu(archive)
        noteMenu.show()
    }
}
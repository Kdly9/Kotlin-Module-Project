import java.util.Scanner

class NoteMenu(private val archive: Archive) : Menu("Меню заметок в архиве '${archive.name}'") {

    override val options: List<Pair<String, () -> Unit>>
        get() = listOf("Создать заметку" to ::createNote) + archive.notes.map { it.title to { viewNote(it) } }


    private fun createNote() {
        println("Введите заголовок заметки:")
        val title = Scanner(System.`in`).nextLine()
        if (title.isBlank()) {
            println("Заголовок не может быть пустым.")
            return
        }

        println("Введите текст заметки:")
        val content = Scanner(System.`in`).nextLine()
        if (content.isBlank()) {
            println("Пустая заметка!")
            return
        }

        archive.notes.add(Note(title, content))
        println("Заметка '$title' создана.")
    }

    private fun viewNote(note: Note) {
        println("Заголовок: ${note.title}")
        println("Содержание: ${note.content}")
    }
}

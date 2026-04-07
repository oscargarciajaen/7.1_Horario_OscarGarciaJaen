package Presentacion

import Datos.TimeTable
import Dominio.TimeTableWriter
import com.github.ajalt.mordant.table.table
import com.github.ajalt.mordant.terminal.Terminal

class LibraryTimeTableWriter : TimeTableWriter {

    private val t = Terminal(width = 150)

    override fun write(timeTable: TimeTable) {
        val tabla = table {
            header {
                row {
                    cell(timeTable.groupName) { columnSpan = 6 }
                }

                val listaDias = mutableListOf("")
                timeTable.rows[0].SubjectsByDay.keys.forEach { dia ->
                    listaDias.add(dia.toString())
                }
                row(*listaDias.toTypedArray())
            }

            body {
                for (i in timeTable.rows.indices) {
                    val filaDatos = mutableListOf<String>()

                    val horas = "${timeTable.rows[i].timeSlot.start}/${timeTable.rows[i].timeSlot.end}"
                    filaDatos.add(horas)

                    for (j in timeTable.rows[i].SubjectsByDay) {
                        filaDatos.add(j.value.toString())
                    }

                    row(*filaDatos.toTypedArray())
                }
            }
        }

        t.println(tabla)    }
}
package Dominio

import Datos.TimeTable

interface TimeTableWriter {

    fun write(timeTable: TimeTable)

}
package Datos

class TimeTableInputData(val groupName: String, val timeSlots: List<TimeSlot>, val subjectsBySlot: Map<TimeSlot, Map<DayOfWeek, String>>) {
}
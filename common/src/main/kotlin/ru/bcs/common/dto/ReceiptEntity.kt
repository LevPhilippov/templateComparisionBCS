package ru.bcs.cctreceiptsenderservice.db.entity


import java.time.LocalDateTime
import java.util.*


class ReceiptEntity (

    var id: UUID? = null,

    val requestId: UUID,

    val templateValues: Map<String, String>,

    val link: String,

    val templateId: UUID,

    val routingKey: String,

    val fiscalSign: String,

    val fiscalDriveNumber: String,

    val fiscalDocumentNumber: String,

    val email: String,

    val clientId: UUID,

    var status: ReceiptStatus,

    var creationDate: LocalDateTime,

    var updateDate: LocalDateTime? = null

)
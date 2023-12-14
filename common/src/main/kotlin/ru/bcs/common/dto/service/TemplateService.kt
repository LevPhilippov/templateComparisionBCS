package ru.bcs.common.dto.service

import ru.bcs.cctreceiptsenderservice.db.entity.ReceiptEntity

interface TemplateService {
    fun processTemplate(entity: ReceiptEntity): String
}
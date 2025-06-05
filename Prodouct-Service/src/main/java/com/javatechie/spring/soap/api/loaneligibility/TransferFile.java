
package com.javatechie.spring.soap.api.loaneligibility;

import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "sessionContext",
        "param"
})
@XmlRootElement(name = "TransferFile")
@ToString
@Data
public class TransferFile {

    @XmlElement(required = true)
    protected SessionContext sessionContext;
    @XmlElement(required = true)
    protected Param param;

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "bankCode",
            "channel",
            "externalBatchNumber",
            "externalSystemAuditTrailNumber",
            "serviceCode",
            "transactionBranch",
            "userId"
    })
    @ToString
    @Data
    public static class SessionContext {

        @XmlElement(required = true)
        protected String bankCode;

        @XmlElement(required = true)
        protected String channel;

        @XmlElement(required = true)
        protected String externalBatchNumber;

        @XmlElement(required = true)
        protected String externalSystemAuditTrailNumber;

        @XmlElement(required = true)
        protected String serviceCode;

        @XmlElement(required = true)
        protected String transactionBranch;

        @XmlElement(required = true)
        protected String userId;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "externalSystemCode",
            "fileCount",
            "fileDetails",
            "requestId"
    })
    @ToString
    @Data
    public static class Param {

        @XmlElement(required = true)
        protected String externalSystemCode;

        @XmlElement(required = true)
        protected String fileCount;

        @XmlElement(required = true)
        protected FileDetails fileDetails;

        @XmlElement(required = true)
        protected String requestId;

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
                "fileExtension",
                "fileName",
                "fileObject",
                "fileTransferMode",
                "fileType",
                "flgCompression",
                "xfSystemCode"
        })
        @ToString
        @Data
        public static class FileDetails {

            @XmlElement(required = true)
            protected String fileExtension;

            @XmlElement(required = true)
            protected String fileName;

            @XmlElement(required = true)
            protected String fileObject;  // Base64-encoded file content

            @XmlElement(required = true)
            protected String fileTransferMode;

            @XmlElement(required = true)
            protected String fileType;

            @XmlElement(required = true)
            protected String flgCompression;

            @XmlElement(required = true)
            protected String xfSystemCode;
        }
    }
}

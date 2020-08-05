LIC_FILES_CHKSUM = "file://COPYRIGHT;md5=4190b39435611e92a4da74e682623f19"

SRC_URI[md5sum] = "19bb20214e0a88629e17a5b6c605d45d"
SRC_URI[sha256sum] = "53a4b4b6569e8ef8b0aa6b7adbf736563467dba67aa77c6f4a37b7387b01508f"

SRC_URI = "http://www.eecis.udel.edu/~ntp/ntp_spool/ntp4/ntp-4.2/ntp-${PV}.tar.gz \
           file://ntp-4.2.4_p6-nano.patch \
           file://reproducibility-fixed-path-to-posix-shell.patch \
           file://ntpd \
           file://ntp.conf \
           file://ntpdate \
           file://ntpdate.default \
           file://ntpdate.service \
           file://ntpd.service \
           file://sntp.service \
           file://sntp \
           file://ntpd.list \
"


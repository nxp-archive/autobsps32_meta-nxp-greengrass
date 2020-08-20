inherit setuptools
require recipes-devtools/python/python-requests.inc

LIC_FILES_CHKSUM = "file://LICENSE;md5=a8d5a1d1c2d53025e2282c511033f6f7"

SRC_URI[md5sum] = "2918817ea4688f4ea21cb4b11e353448"
SRC_URI[sha256sum] = "ea881206e59f41dbd0bd445437d792e43906703fff75ca8ff43ccdb11f33f263"

RDEPENDS_${PN} += "${PYTHON_PN}-zlib"

inherit setuptools
require recipes-devtools/python/python-requests.inc

LIC_FILES_CHKSUM = "file://LICENSE;md5=979d6a23b143e13ea0e5e3aa81248820"

SRC_URI[md5sum] = "4c3c169ed67466088a2a6947784fe444"
SRC_URI[sha256sum] = "a274abba399a23e8713ffd2b5706535ae280ebe2b8069ee6a941cb089440d153"

RDEPENDS_${PN} += "${PYTHON_PN}-zlib"

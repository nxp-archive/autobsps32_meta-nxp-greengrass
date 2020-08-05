inherit pypi setuptools
require recipes-devtools/python/python-jsonschema.inc

SRC_URI[md5sum] = "50c6b69a373a8b55ff1e0ec6e78f13f4"
SRC_URI[sha256sum] = "6ff5f3180870836cae40f06fa10419f557208175f13ad7bc26caa77beb1f6e02"

RDEPENDS_${PN} += " \
    ${PYTHON_PN}-argparse \
    ${PYTHON_PN}-contextlib \
    ${PYTHON_PN}-functools32 \
    ${PYTHON_PN}-lang \
    ${PYTHON_PN}-re \
    ${PYTHON_PN}-subprocess \
    ${PYTHON_PN}-textutils \ 
"

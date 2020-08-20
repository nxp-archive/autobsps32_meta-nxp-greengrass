inherit pypi setuptools
require recipes-devtools/python/python-docker.inc

RDEPENDS_${PN} += " \
                   python-backports-ssl \
                  "

SUMMARY = "Edge TPU library"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

HOMEPAGE = "https://github.com/alejandrolozano2/libedgetpu"
SRC_URI = "git://github.com/alejandrolozano2/libedgetpu.git;protocol=https;branch=master"
SRCREV = "589e838c0b0028125bbd1e452e477ec4d4abc220"

S = "${WORKDIR}/git"

RDEPENDS_${PN} = "libusb1 libcxx"

do_compile () {
  echo "Do nothing"
}

do_install () {

    install -d ${D}/${libdir}
    install -m 755 ${S}/out/throttled/aarch64/libedgetpu.so.1.0 \
                   ${D}/${libdir}/libedgetpu.so.1.0
    ln -sf ${libdir}/libedgetpu.so.1.0 ${D}/${libdir}/libedgetpu.so.1
    ln -sf ${libdir}/libedgetpu.so.1.0 ${D}/${libdir}/libedgetpu.so

}

INSANE_SKIP_${PN} += "already-stripped"

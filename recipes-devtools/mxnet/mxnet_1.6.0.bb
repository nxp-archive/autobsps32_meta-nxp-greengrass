SUMMARY = "MXNET Package"
SECTION = "libs"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d062b5a0431dc3d14e07b356e09ed27b"
#LIC_FILES_CHKSUM = "file://LICENSE;md5=2d3f324e3bd2ec2117705219a25f2fe1"
#LIC_FILES_CHKSUM = "file://LICENSE;md5=6b7b3af6e4e08c3a7e0e027a6809cad1"
#LIC_FILES_CHKSUM = "file://LICENSE;md5=6e477e47e101063cf3370e2495c85d5e" 
#LIC_FILES_CHKSUM = "file://LICENSE;md5=bea76d64fe6f7e778c44003c8bdd7bdb"
DEPENDS = "libopenblas glib-2.0 glibc "
 
SRC_URI := "https://archive.apache.org/dist/incubator/mxnet/${PV}/apache-${PN}-src-${PV}-incubating.tar.gz "

SRC_URI[md5sum] = "76802d6b14cd45c27f063b2bba3c9a14"
SRC_URI[sha256sum] = "01eb06069c90f33469c7354946261b0a94824bbaf819fd5d5a7318e8ee596def"
#SRC_URI[md5sum] = "037d68ea54a3a362316b1b681b41d11f"
#SRC_URI[sha256sum] = "c00d6fbb2947144ce36c835308e603f002c1eb90a9f4c5a62f4d398154eed4d2"
#SRC_URI[md5sum] = "f75a2716700f68d7d35a9ca595b9ac3f"
#SRC_URI[sha256sum] = "6259fa42fd086021e9e1abc44a1d73cb797ed80f86fc76633a1449a25f5b7f14"

#SRC_URI[md5sum] = "86984618f496bf70b9790a5f4d773677"
#SRC_URI[sha256sum] = "e9c86d225c760b021abca4ab9f4406c57881d411cb4c140ff960c3c88c223a8f"

#SRC_URI[md5sum] = "a9db0445b776efbda22726f18db00470"
#SRC_URI[sha256sum] = "2793dc571cf1d1c755b8d66ac0f9e70a5f554cff035eb180933e6877c30dbad5"
#SRC_URI[md5sum] = "9e121140d09bcfc5dcd78afca5b475ff"
#SRC_URI[sha256sum] = "67a23738fc5e0b1d0fa5d67d079f85230fe26d53a6c2e46439441f62ce2a53b2" 
S := "${WORKDIR}/apache-${PN}-src-${PV}-incubating"
 
inherit cmake
 
OECMAKE_GENERATOR = "Unix Makefiles"
 
EXTRA_OECMAKE += " -DUSE_SSE=OFF \
-DUSE_CUDA=OFF \
-DUSE_OPENCV=OFF \
-DUSE_OPENMP=OFF \
-DUSE_MKL_IF_AVAILABLE=OFF \
-DUSE_SIGNAL_HANDLER=ON \
-DUSE_LAPACK=OFF \
-DBLAS=open"

ALLOW_EMPTY_${PN} = "1"
INSANE_SKIP_${PN}-dev += "installed-vs-shipped" 
PACKAGES = "${PN} ${PN}-dev"
INSANE_SKIP_${PN} += "installed-vs-shipped" 

 
do_compile_prepend () {
        find ${S}/../build -name flags.* -type f -exec sed -i -e 's/-isystem/-I/g' {} \;
}

do_install() {
	install -d -m 0755 ${D}${libdir}
	cp ${B}/libmxnet.so ${D}${libdir}
}

FILES_${PN} = "${libdir}/libmxnet.so "
 
INSANE_SKIP_${PN}-dev += "dev-elf"

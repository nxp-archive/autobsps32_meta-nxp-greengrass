DESCRIPTION = "OpenBLAS is an optimized BLAS library based on GotoBLAS2 1.13 BSD version." 
SUMMARY = "OpenBLAS : An optimized BLAS library" 
HOMEPAGE = "http://www.openblas.net/" 
SECTION = "libs" 
LICENSE = "BSD-3-Clause" 


DEPENDS = "make libgfortran" 


LIC_FILES_CHKSUM = "file://LICENSE;md5=5adf4792c949a00013ce25d476a2abc0" 


SRC_URI = "https://github.com/xianyi/OpenBLAS/archive/v${PV}.tar.gz" 
SRC_URI[md5sum] = "8a110a25b819a4b94e8a9580702b6495" 
SRC_URI[sha256sum] = "e64c8fe083832ffbc1459ab6c72f71d53afd3b36e8497c922a15a06b72e9002f" 


S = "${WORKDIR}/OpenBLAS-${PV}" 

do_compile () { 
    if [ ${DEFAULTTUNE} = "aarch64" ]; then
        oe_runmake TARGET=ARMV8     \
                                HOSTCC="${BUILD_CC}"                                         \ 
								AR="${TARGET_PREFIX}ar"                        \
                                NOFORTRAN=0 NO_LAPACK=1 USE_OPENMP=1 USE_THREAD=4
		oe_runmake -C utest TARGET=ARMV8     \
                                HOSTCC="${BUILD_CC}"                                         \ 
                                NOFORTRAN=0 NO_LAPACK=1 USE_OPENMP=1 USE_THREAD=4
	else
	    oe_runmake TARGET=ARMV7     \
                                HOSTCC="${BUILD_CC}"                                         \ 
								AR="${TARGET_PREFIX}ar"                        \
                                NOFORTRAN=1 NO_LAPACK=1 USE_THREAD=0
		oe_runmake -C utest TARGET=ARMV7     \
                                HOSTCC="${BUILD_CC}"                                         \ 
                                NOFORTRAN=1 NO_LAPACK=1 USE_THREAD=0
	fi
} 

FILES_${PN}-dev += "${libdir}/cmake/openblas"
INSANE_SKIP_${PN}-dev += "dev-elf"
INSANE_SKIP_${PN} += "dev-deps"
do_install() {
        oe_runmake DESTDIR=${D} PREFIX=${prefix} install

        rmdir ${D}${bindir}
}


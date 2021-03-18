# Copyright (C) 2013-2016 Freescale Semiconductor
# Copyright 2017-2020 NXP
# Released under the MIT license (see COPYING.MIT for the terms)

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = " \
        file://0001-openjdk-8-ARCHFLAG.patch \
"
do_compile_prepend_s32g274aevb() {
        export ARCHFLAGS=" ${TARGET_CXXFLAGS}"
}

do_compile_prepend_s32g274ardb() {
        export ARCHFLAGS=" ${TARGET_CXXFLAGS}"
}

do_compile_prepend_s32g274ardb2() {
        export ARCHFLAGS=" ${TARGET_CXXFLAGS}"
}

# Copyright (C) 2013-2016 Freescale Semiconductor
# Copyright 2017-2020 NXP
# Released under the MIT license (see COPYING.MIT for the terms)

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = " \
        file://0001-openjdk-8-ARCHFLAG.patch \
"
do_compile_prepend() {
        export ARCHFLAGS=" ${TARGET_CXXFLAGS}"
}

# Copyright (C) 2013-2016 Freescale Semiconductor
# Copyright 2017-2020 NXP
# Released under the MIT license (see COPYING.MIT for the terms)

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = " \
	file://greengrass_defconfig \
"

do_configure_append() {

cp ${WORKDIR}/greengrass_defconfig ${WORKDIR}/build/.config
}

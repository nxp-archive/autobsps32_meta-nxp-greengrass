# Copyright (C) 2013-2016 Freescale Semiconductor
# Copyright 2017-2020 NXP
# Released under the MIT license (see COPYING.MIT for the terms)

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

#FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:${THISDIR}/files:"
DELTA_KERNEL_DEFCONFIG_append += " greengrass.cfg"
SRC_URI_append = " \
	file://build/greengrass.cfg \
"


#Copyright (C) 2013-2016 Freescale Semiconductor
# Copyright 2017-2020 NXP
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "Scritp to up eth0 interface"
DESCRIPTION = "This installs iscript to configure eth0 at boot time"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI = "file://nxp_networking.sh"

inherit update-rc.d
INITSCRIPT_PACKAGES = "${PN}"
INITSCRIPT_NAME = "nxp_networking.sh"

do_install() {
  install -d ${D}${INIT_D_DIR}
  install -m 0755 ${WORKDIR}/${INITSCRIPT_NAME} ${D}${INIT_D_DIR}/${INITSCRIPT_NAME}
}

FILES_${PN} = "${INIT_D_DIR}/${INITSCRIPT_NAME}"

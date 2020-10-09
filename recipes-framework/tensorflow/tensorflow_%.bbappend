# Copyright (C) 2013-2016 Freescale Semiconductor
# Copyright 2017-2020 NXP
# Released under the MIT license (see COPYING.MIT for the terms)

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append = " \
        file://0001-ICU-Bazel-User-second-URL-and-change-sha256.patch \
"

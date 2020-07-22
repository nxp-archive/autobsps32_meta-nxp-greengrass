# Copyright (C) 2013-2016 Freescale Semiconductor
# Copyright 2017-2020 NXP
# Released under the MIT license (see COPYING.MIT for the terms)

do_install_append () {
       for lib in $(ls ${D}${libdir}/*-static.a); do
               mv -v "${lib}" "$(echo ${lib} | sed s/-static//)"
       done
}

BBCLASSEXTEND = "native"

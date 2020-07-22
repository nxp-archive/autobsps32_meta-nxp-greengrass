do_install_append () {
       for lib in $(ls ${D}${libdir}/*-static.a); do
               mv -v "${lib}" "$(echo ${lib} | sed s/-static//)"
       done
}

BBCLASSEXTEND = "native"

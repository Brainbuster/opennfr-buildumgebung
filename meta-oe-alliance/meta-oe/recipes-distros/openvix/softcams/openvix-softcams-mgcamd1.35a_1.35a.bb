SUMMARY = "mgcamd ${PV} softcam"
LICENSE = "CLOSED"
require conf/license/license-close.inc

RDEPENDS_${PN} = "libcrypto-compat-0.9.7"

PR = "r4"

RREPLACES_${PN} += "enigma2-plugin-softcams-mgcamd"
RCONFLICTS_${PN} += "enigma2-plugin-softcams-mgcamd"

PACKAGES = "enigma2-plugin-softcams-mgcamd135a"

PROVIDES += "openvix-softcams-mgcamd135a"
RPROVIDES_enigma2-plugin-softcams-mgcamd135a += "openvix-softcams-mgcamd135a"

SRC_URI = "http://openvix.co.uk/feeds_extras/softcams/mgcamd-1.35a.zip"

S = "${WORKDIR}/mgcamd-1.35a"

INHIBIT_PACKAGE_STRIP = "1"

do_install() {
    install -d ${D}/usr/softcams
    install -m 0755 ${S}/mgcamd.mipsel ${D}/usr/softcams/mgcamd.${PV}
}

SRC_URI[md5sum] = "c23a69c16fa79cd5a284da7f531585d6"
SRC_URI[sha256sum] = "339e564db48b701be002d047189ac658d2021673bbc235005dec24f26abac39e"

FILES_enigma2-plugin-softcams-mgcamd135a = "/usr"
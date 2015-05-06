SUMMARY = "openViX bootlogo Helios pack1"
LICENSE = "CLOSED"
require conf/license/license-close.inc

inherit allarch

PV = "1.0"
PR = "r1"

SRC_URI = "http://openvix.co.uk/feeds_extras/bootlogos/openvix-helios.zip"

S = "${WORKDIR}"

do_install() {
    install -d ${D}/etc/enigma2
    install -m 0644 bootlogo.mvi ${D}/etc/enigma2/bootlogo.mvi
    install -m 0644 backdrop.mvi ${D}/etc/enigma2/backdrop.mvi
    install -m 0644 radio.mvi ${D}/etc/enigma2/radio.mvi
}

SRC_URI[md5sum] = "8cf095009dd1dbd84aecf19082782713"
SRC_URI[sha256sum] = "5b8d6a615a1a364b49c33d37ed0f1f406ff8dcb19c6d6c12c2cbdc54b7abe85b"

FILES_${PN} = "/etc"
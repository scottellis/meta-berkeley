require recipes-kernel/linux/linux-yocto.inc

KERNEL_IMAGETYPE = "zImage"

COMPATIBLE_MACHINE = "overo"

RDEPENDS_kernel-base += "kernel-devicetree"

KERNEL_DEVICETREE = " \
    omap3-overo-storm-tobi.dtb \
    omap3-overo-tobi.dtb \
 "

LINUX_VERSION = "4.9"
LINUX_VERSION_EXTENSION = "-lbl"

FILESEXTRAPATHS_prepend := "${THISDIR}/linux-stable-4.9:"

S = "${WORKDIR}/git"

PR = "r1"

PV = "4.9.19"
SRCREV = "c8e131605de2e0d1d5769ff25272ae1c8e4720b0"
SRC_URI = " \
    git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;branch=linux-4.9.y \
    file://defconfig \
 "

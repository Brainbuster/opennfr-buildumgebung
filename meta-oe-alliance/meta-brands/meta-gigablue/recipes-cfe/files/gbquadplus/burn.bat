macprog2 AC-DB-EF-11-22-33

flash -noheader -forceerase usbdisk0:gigablue/quadplus/kernel.bin flash0.kernel

flash -noheader -forceerase usbdisk0:gigablue/quadplus/rootfs.bin flash0.rootfs

setenv -p STARTUP "boot -z -elf flash0.kernel:"

boot -z -elf flash0.kernel:

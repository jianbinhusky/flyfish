package socket.tcp.ip;

import java.net.*;
import java.util.Enumeration;

public class InetAddressExample {
    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> interfaceList = NetworkInterface.getNetworkInterfaces();
            if (interfaceList == null) {
                System.out.println("-- No interfaces found --");
            } else {
                while (interfaceList.hasMoreElements()) {
                    NetworkInterface iface = interfaceList.nextElement();
                    System.out.println("Interface " + iface.getName() + "("+iface.getDisplayName()+")" + " : ");
                    Enumeration<InetAddress> addrList = iface.getInetAddresses();
                    if (!addrList.hasMoreElements()) {
                        System.out.println("\t (No address for this interface)");
                    }
                    while (addrList.hasMoreElements()) {
                        InetAddress address = addrList.nextElement();
                        System.out.print("\tAddress " + ((address instanceof Inet4Address ? "(v4)" : (address instanceof Inet6Address ? "(v6)" : "(?)"))));
                        System.out.println(": " + address.getHostAddress());
                    }
                }
            }
        } catch (SocketException e) {
            System.out.println("Error getting network interfaces:" + e.getMessage());
            e.printStackTrace();
        }

        String[] hosts = {"202.91.32.245","baidu.com","google.com.hk","google.com"};
        for (String host : hosts) {
            System.out.println(host + " : ");
            try {
                InetAddress[] addressList = InetAddress.getAllByName(host);
                for (InetAddress address : addressList) {
                    System.out.println("\t" + address.getHostName() + "/" + address.getHostAddress());
                }
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }
    }
}

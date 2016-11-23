/*
 *
 *  *  Copyright 2016 Infuzion
 *  *
 *  *    Licensed under the Apache License, Version 2.0 (the "License");
 *  *    you may not use this file except in compliance with the License.
 *  *    You may obtain a copy of the License at
 *  *
 *  *        http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  *    Unless required by applicable law or agreed to in writing, software
 *  *    distributed under the License is distributed on an "AS IS" BASIS,
 *  *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  *    See the License for the specific language governing permissions and
 *  *    limitations under the License.
 *
 */

package infuzion.chat.server.permission;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

public class PermissionAttachmentTest {
    @Test
    public void addPermission() throws Exception {
        PermissionAttachment pA = new PermissionAttachment();

        Permission permission1 = new Permission("1");
        pA.addPermission(permission1);
        assertTrue(pA.getPermissions().contains(permission1));
    }

    @Test
    public void nonNullList() throws Exception {
        List<Permission> permissions = new ArrayList<>();
        permissions.add(new Permission("1"));
        permissions.add(new Permission("2"));
        permissions.add(new Permission("3"));
        permissions.add(new Permission("4"));
        PermissionAttachment pA = new PermissionAttachment(permissions);
        assertTrue(pA.containsPermission(new Permission("1")));
        assertTrue(pA.containsPermission(new Permission("2")));
        assertTrue(pA.containsPermission(new Permission("3")));
        assertTrue(pA.containsPermission(new Permission("4")));
    }

    @Test
    public void equals() {
        PermissionAttachment pA = new PermissionAttachment();
        pA.addPermission(new Permission("213"));
        Object obj = new Object();
        assertFalse(pA.equals(obj));

        PermissionAttachment pA1 = new PermissionAttachment();
        pA1.addPermission(new Permission("123"));

        assertFalse(pA.equals(pA1));
        assertFalse(pA1.equals(pA));

        pA.addPermission(new Permission("123"));
        pA1.addPermission(new Permission("213"));

        assertTrue(pA.equals(pA1));
        assertTrue(pA1.equals(pA));
    }

    @Test
    public void addPermissions() throws Exception {
        Permission[] permissions = new Permission[5];
        permissions[0] = new Permission("1");
        permissions[1] = new Permission("2");
        permissions[2] = new Permission("3");
        permissions[3] = new Permission("4");
        permissions[4] = new Permission("5");

        List<Permission> permissionList1 = new ArrayList<>();
        permissionList1.add(permissions[0]);
        permissionList1.add(permissions[1]);
        permissionList1.add(permissions[2]);
        permissionList1.add(permissions[3]);
        PermissionAttachment check1 = new PermissionAttachment(permissionList1);

        PermissionAttachment pA1 = new PermissionAttachment();
        pA1.addPermission(permissions[0]);
        pA1.addPermission(permissions[1]);
        PermissionAttachment pA2 = new PermissionAttachment();
        pA2.addPermission(permissions[2]);
        pA2.addPermission(permissions[3]);
        pA1.addPermissions(pA2);

        assertEquals(check1.getPermissions(), pA1.getPermissions());
    }

    @Test
    public void getPermissions() throws Exception {
        PermissionAttachment pA = new PermissionAttachment();
        assertEquals(0, pA.getPermissions().size());
        pA.addPermission(new Permission("123"));
        assertEquals(1, pA.getPermissions().size());
        for (int x = 0; x < 100; x++) {
            pA.addPermission(new Permission("permission." + x));
        }
        assertEquals(101, pA.getPermissions().size());
    }

    @Test
    public void containsPermission() throws Exception {
        PermissionAttachment pA = new PermissionAttachment();
        pA.addPermission(new Permission("123"));
        assertTrue(pA.containsPermission(new Permission("123")));
    }

    @Test
    public void iterator() throws Exception {
        PermissionAttachment pA = new PermissionAttachment();
        Permission[] permissions = new Permission[5];
        permissions[0] = new Permission("1");
        permissions[1] = new Permission("2");
        permissions[2] = new Permission("3");
        permissions[3] = new Permission("4");
        permissions[4] = new Permission("5");
        for (Permission p : permissions) {
            pA.addPermission(p);
        }
        Iterator iterator = pA.iterator();
        int counter = 0;
        assertTrue(iterator.hasNext());
        while (iterator.hasNext()) {
            assertEquals(iterator.next(), permissions[counter]);
            counter++;
        }
        assertEquals(5, counter);
    }

}
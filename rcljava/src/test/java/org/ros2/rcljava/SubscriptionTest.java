/* Copyright 2016 Esteve Fernandez <esteve@apache.org>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.ros2.rcljava;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class SubscriptionTest {

  @Test
  public void testCreate() {
    RCLJava.rclJavaInit();
    Node node = RCLJava.createNode("test_node");
    Subscription<std_msgs.msg.String> subscription = node.
      <std_msgs.msg.String>createSubscription(std_msgs.msg.String.class,
      "test_topic", new Consumer<std_msgs.msg.String>() {
        public void accept(std_msgs.msg.String msg) {
        }
      }
    );
    assertEquals(node.getNodeHandle(), subscription.getNodeHandle());
    assertNotEquals(0, subscription.getNodeHandle());
    assertNotEquals(0, subscription.getSubscriptionHandle());
  }
}
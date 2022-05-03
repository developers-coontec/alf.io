/**
 * This file is part of alf.io.
 * <p>
 * alf.io is free software: you can redistribute it and/or modify it under the terms of the GNU
 * General Public License as published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * <p>
 * alf.io is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even
 * the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General
 * Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License along with alf.io.  If not, see
 * <http://www.gnu.org/licenses/>.
 */
package alfio.util;

import java.sql.Timestamp;
import java.time.ZonedDateTime;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SqlUtils {

  public static ZonedDateTime timestampToZoneDateTime(Timestamp timestamp) {
    if (timestamp == null) {
      return null;
    }
    return ZonedDateTime.ofInstant(timestamp.toInstant(), ClockProvider.clock().getZone());
  }
}

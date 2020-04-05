import { Moment } from 'moment';
import { IUser } from 'app/shared/model/user.model';

export interface IBooking {
  id?: number;
  date?: Moment;
  startTime?: string;
  endTime?: string;
  title?: string;
  comment?: string;
  creator?: IUser;
  owner?: IUser;
}

export const defaultValue: Readonly<IBooking> = {};
